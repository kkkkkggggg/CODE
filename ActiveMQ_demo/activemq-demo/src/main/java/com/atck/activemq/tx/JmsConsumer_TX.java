package com.atck.activemq.tx;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumer_TX
{
    public static final String ACTIVEMQ_URL="tcp://192.168.153.132:61616";
    public static final String QUEUE_NAME="queue01";
    public static void main(String[] args) throws JMSException, IOException
    {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        Connection connection = connectionFactory.createConnection();

        connection.start();

        Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);

        Queue queue = session.createQueue(QUEUE_NAME);

        MessageConsumer consumer = session.createConsumer(queue);

        consumer.setMessageListener((message -> {
            if (null != message)
            {
                TextMessage textMessage = (TextMessage) message;

                try
                {

                    System.out.println("接收到队列的消息：" + textMessage.getText());
                    //在开启事务的情况下，只要session.commit()提交了事务，textMessage.acknowledge()写不写都会自动提交，但是不提交事务，手动签收消息会出现重复消费
                    // textMessage.acknowledge();
                } catch (JMSException e)
                {
                    e.printStackTrace();
                }
            }
        }));

        System.in.read();

        consumer.close();
        session.commit();
        session.close();
        connection.close();
    }
}
