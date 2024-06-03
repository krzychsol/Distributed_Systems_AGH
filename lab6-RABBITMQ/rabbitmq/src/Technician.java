import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Technician {
    private static final String LOG_EXCHANGE_NAME = "admin";
    private static final String LOG_KEY = "admin";
    private static final String INFO_KEY = "info";
    private static final String EXCHANGE_NAME = "examination";

    private static String queueName1, queueName2, infoQueue;
    private static Channel channel;

    public static void main(String[] args) throws Exception {
        Connection connection = RabbitMQConfig.getConnection();
        channel = RabbitMQConfig.createChannel(connection);

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        initializeQueues();
        setupInfoQueue();

        Consumer consumer = createConsumer();
        channel.basicConsume(queueName1, true, consumer);
        channel.basicConsume(queueName2, true, consumer);
        channel.basicConsume(infoQueue, true, consumer);

        System.out.printf("Ready to work with %s and %s%n", queueName1, queueName2);
    }

    private static void initializeQueues() throws Exception {
        System.out.println("Enter what injuries technician will handle: ");
        queueName1 = getValidInjuryName();
        queueName2 = getValidInjuryName();
        while (queueName1.equals(queueName2)) {
            System.out.println("Injury types have to be different");
            queueName2 = getValidInjuryName();
        }
        RabbitMQConfig.setupExchangeAndQueue(channel, EXCHANGE_NAME, queueName1, BuiltinExchangeType.DIRECT);
        RabbitMQConfig.setupExchangeAndQueue(channel, EXCHANGE_NAME, queueName2, BuiltinExchangeType.DIRECT);
    }

    private static void setupInfoQueue() throws IOException {
        infoQueue = channel.queueDeclare().getQueue();
        channel.queueBind(infoQueue, LOG_EXCHANGE_NAME, INFO_KEY);
        channel.basicQos(1);
    }

    private static String getValidInjuryName() {
        Scanner scanner = new Scanner(System.in);
        String injury;
        do {
            injury = scanner.nextLine();
            if (!isValidInjuryName(injury)) {
                System.out.println("Injury name has to be one of: knee, hip, elbow");
            }
        } while (!isValidInjuryName(injury));
        return injury;
    }

    private static boolean isValidInjuryName(String name) {
        return name.equals("knee") || name.equals("hip") || name.equals("elbow");
    }

    private static Consumer createConsumer() {
        return new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("Received: " + message);
                handleDeliveryMessage(message, envelope.getRoutingKey());
            }
        };
    }

    private static void handleDeliveryMessage(String message, String routingKey) {
        String[] info = message.split(" ");
        String resultExchangeName = "results";
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!message.equals("INFO MESSAGE")) {
            String resultMessage = String.format("%s %s %s", info[1], routingKey, "done");
            try {
                channel.basicPublish(resultExchangeName, info[0], null, resultMessage.getBytes(StandardCharsets.UTF_8));
                channel.basicPublish(LOG_EXCHANGE_NAME, LOG_KEY, null, resultMessage.getBytes(StandardCharsets.UTF_8));
                System.out.println("Sent: " + resultMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
