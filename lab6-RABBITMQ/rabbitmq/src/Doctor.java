import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Doctor {
    private static final String LOG_EXCHANGE_NAME = "admin";
    private static final String LOG_KEY = "admin";
    private static final String INFO_KEY = "info";
    private static final String EXCHANGE_NAME = "examination";

    private static String doctorName;
    private static Channel channel;

    public static void main(String[] args) throws Exception {
        Connection connection = RabbitMQConfig.getConnection();
        channel = RabbitMQConfig.createChannel(connection);

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        doctorName = getDoctorName();
        Thread receiver = new Thread(new ReceiveMessage());
        receiver.start();

        while (true) {
            String injury = getInjuryName();
            if (injury.equals("exit")) break;
            if (!isValidInjuryName(injury)) {
                System.out.println("Bad injury name");
                continue;
            }
            String clientName = getClientName();
            sendMessage(injury, clientName);
        }
    }

    private static String getDoctorName() {
        System.out.println("Enter doctor name: ");
        return new Scanner(System.in).nextLine();
    }

    private static String getInjuryName() {
        System.out.println("Enter injury name: ");
        return new Scanner(System.in).nextLine();
    }

    private static boolean isValidInjuryName(String injury) {
        return injury.equals("knee") || injury.equals("hip") || injury.equals("elbow");
    }

    private static String getClientName() {
        System.out.println("Enter client name: ");
        return new Scanner(System.in).nextLine();
    }

    private static void sendMessage(String injury, String clientName) throws IOException {
        String message = String.format("%s %s", doctorName, clientName);
        channel.basicPublish(EXCHANGE_NAME, injury, null, message.getBytes(StandardCharsets.UTF_8));
        channel.basicPublish(LOG_EXCHANGE_NAME, LOG_KEY, null, message.getBytes(StandardCharsets.UTF_8));
        System.out.println("Sent: " + message);
    }

    private static class ReceiveMessage implements Runnable {
        @Override
        public void run() {
            String exchangeName = "results";

            try {
                channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT);
                channel.queueDeclare(doctorName, false, false, false, null);
                channel.queueDeclare(doctorName + "info", false, false, false, null);
                channel.queueBind(doctorName, exchangeName, doctorName);
                channel.queueBind(doctorName + "info", LOG_EXCHANGE_NAME, INFO_KEY);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, StandardCharsets.UTF_8);
                    System.out.println("Message: " + message);
                }
            };

            try {
                channel.basicConsume(doctorName, true, consumer);
                channel.basicConsume(doctorName + "info", true, consumer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    }
