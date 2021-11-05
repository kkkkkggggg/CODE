package com.atck.activemq.persist;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsTopic_Persist
{
    public static final String  ACTIVEMQ_TOPIC = "topic01";
    public static final String  ACTIVEMQ_URL = "tcp://192.168.153.132:61616";

    public static void main(String[] args) throws JMSException
    {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        Connection connection = connectionFactory.createConnection();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(ACTIVEMQ_TOPIC);

        MessageProducer producer = session.createProducer(topic);

        producer.setDeliveryMode(DeliveryMode.PERSISTENT);

        //持久化主题，要在设置完持久化之后再启动连接
        connection.start();

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
