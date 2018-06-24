package simpleHelloWorld;

import com.cvent.rabbitmq.MessageEnvelope;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by pparth on 1/13/17.
 */
public class Send {

    private static final String QUEUE_NAME = "hello";
    /**
     *
     * @param argv
     * @throws Exception
     */
    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for(int i=0;i<1;i++){
            List<UUID> allUuids = new ArrayList<UUID>();
            allUuids.add(UUID.randomUUID());
            MessageEnvelope<UUID> message = new MessageEnvelope<UUID>(
                    allUuids, "S2", "rfp_response_rate_loader", "responserate_bulk_update");
            channel.basicPublish("", QUEUE_NAME, null, message.getB);
            System.out.println(" [x] Sent '" + message + "'");
        }

        channel.close();
        connection.close();
    }
}
