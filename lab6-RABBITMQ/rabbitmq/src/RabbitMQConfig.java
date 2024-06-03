import com.rabbitmq.client.*;

public class RabbitMQConfig {
    private static final String HOST = "localhost";

    public static Connection getConnection() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        return factory.newConnection();
    }

    public static Channel createChannel(Connection connection) throws Exception {
        return connection.createChannel();
    }

    public static void setupExchangeAndQueue(Channel channel, String exchangeName, String queueName, BuiltinExchangeType type) throws Exception {
        channel.exchangeDeclare(exchangeName, type);
        channel.queueDeclare(queueName, false, false, false, null);
        channel.queueBind(queueName, exchangeName, queueName);
    }
}
