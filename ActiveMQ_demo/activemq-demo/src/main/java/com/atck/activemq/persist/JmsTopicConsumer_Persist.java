package com.atck.activemq.persist;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsTopicConsumer_Persist
{
    public static final String  ACTIVEMQ_TOPIC = "topic01";
    public static final String  ACTIVEMQ_URL = "tcp://192.168.153.132:61616";

    public static void main(String[] args) throws JMSException, IOException
    {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        Connection connection = connectionFactory.createConnection();

        connection.setClientID("z3");

        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(ACTIVEMQ_TOPIC);

        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic, "remark....");

        connection.start();

        Message message = topicSubscriber.receive(4000L);

        while (null != message)
        {
            TextMessage textMessage = (TextMessage) message;

            System.out.println(textMessage.getText());

            message = topicSubscriber.receive(4000L);
        }
        session.close();
        connection.close();
    }

    /*
    1.一定要先运行一次消费者，等于向MQ注册，类似订阅了这个主题
    2.然后再运行生产者发送消息，此时无论消费者是否在线，都会接收到，不在线的话，下次连接的时候，会把没有接收过的信息都接收下来
     */
}
