package com.atck.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsTopicConsumer
{
    public static final String  ACTIVEMQ_TOPIC = "topic01";
    public static final String  ACTIVEMQ_URL = "tcp://192.168.153.132:61616";

    public static void main(String[] args) throws JMSException, IOException
    {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        Connection connection = connectionFactory.createConnection();

        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(ACTIVEMQ_TOPIC);

        MessageConsumer consumer = session.createConsumer(topic);

        // while(true)
        // {
        //     TextMessage textMessage = (TextMessage) consumer.receive();
        //
        //     if (null != textMessage)
        //     {
        //         System.out.println(textMessage.getText());
        //     }else
        //     {
        //         break;
        //     }
        //
        // }

        consumer.setMessageListener((message) ->
        {
            if (null != message)
            {
                TextMessage textMessage = (TextMessage) message;
                try
                {
                    System.out.println(textMessage.getText());
                } catch (JMSException e)
                {
                    e.printStackTrace();
                }
            }
        });

        System.in.read();

        consumer.close();
        session.close();
        connection.close();
    }
}
