import com.rabbitmq.client.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Admin {
    public static final String EXCHANGE_NAME = "admin";
    public static final String QUEUE_NAME = "admin";
    public static final String INFO_KEY = "info";
    public static BufferedWriter writer;


    public static void main(String[] args) throws Exception {
        Connection connection = RabbitMQConfig.getConnection();
        Channel channel = RabbitMQConfig.createChannel(connection);

        RabbitMQConfig.setupExchangeAndQueue(channel, EXCHANGE_NAME, QUEUE_NAME, BuiltinExchangeType.DIRECT);

        writer = new BufferedWriter(new FileWriter("logs.log"));

        Consumer consumer = createConsumer(channel);
        channel.basicConsume(QUEUE_NAME, true, consumer);

        Thread infoSender = new Thread(new InfoSender(channel));
        infoSender.start();
    }

    private static Consumer createConsumer(Channel channel) {
        return new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("LOG -- " + message);
                writer.write("LOG -- " + message + "\n");
                writer.flush();
            }
        };
    }

    private static class InfoSender implements Runnable {
        private final Channel channel;

        InfoSender(Channel channel) {
            this.channel = channel;
        }

        @Override
        public void run() {
            System.out.println("TO SEND INFO MESSAGE WRITE 'INFO'");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String info = scanner.nextLine();
                if (info.equals("INFO")) sendInfo();
            }
        }

        private void sendInfo() {
            try {
                channel.basicPublish(EXCHANGE_NAME, INFO_KEY, null, "INFO MESSAGE".getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}