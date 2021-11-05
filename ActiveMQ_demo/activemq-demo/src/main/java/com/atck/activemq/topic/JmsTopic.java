package com.atck.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsTopic
{
    public static final String  ACTIVEMQ_TOPIC = "topic01";
    public static final String  ACTIVEMQ_URL = "tcp://192.168.153.132:61616";

    public static void main(String[] args) throws JMSException
    {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        Connection connection = connectionFactory.createConnection();

        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(ACTIVEMQ_TOPIC);

        MessageProducer producer = session.createProducer(topic);

        for (int i = 0; i < 20; i++)
        {
            TextMessage textMessage = session.createTextMessage("msg----" + i);

            producer.send(textMessage);
        }

        producer.close();
        session.close();
        connection.close();


    }
}
