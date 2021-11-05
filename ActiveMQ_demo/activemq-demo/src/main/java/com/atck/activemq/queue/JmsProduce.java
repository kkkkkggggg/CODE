package com.atck.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.ArrayList;
import java.util.List;

public class JmsProduce
{
    // public static final String ACTIVEMQ_URL="tcp://192.168.153.132:61616";
    public static final String ACTIVEMQ_URL="tcp://localhost:61616";
    public static final String QUEUE_NAME="queue01";

    public static void main(String[] args) throws JMSException
    {
        //1.创建连接工厂,按照给定的url，按照默认用户名和密码连接
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        //2.通过连接工厂，获得连接
        Connection connection = factory.createConnection();

        connection.start();

        //3.创建会话session
        //两个参数：事务、签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //4.创建目的地（具体是队列还是主题topic）
        Queue queue = session.createQueue(QUEUE_NAME);

        //5.创建消息的生产者
        MessageProducer producer = session.createProducer(queue);

        producer.setDeliveryMode(DeliveryMode.PERSISTENT);

        //6.使用消息生产这生产三条消息发送到MQ的队列里
        for (int i = 0; i < 3; i++)
        {
            //7.创建消息
            TextMessage textMessage = session.createTextMessage("msg---" + i);//理解为一个字符串
            //8.通过消息生产者发布
            producer.send(textMessage);

        }

        //9.关闭资源
        producer.close();
        session.close();
        connection.close();

        System.out.println("----消息发布到MQ完成----");
    }
}
