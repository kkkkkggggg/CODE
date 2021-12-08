package com.atck.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumer
{
    // public static final String ACTIVEMQ_URL="failover:(tcp://192.168.153.132:61616,tcp://192.168.153.132:61617,tcp://192.168.153.132:61618)";
    public static final String ACTIVEMQ_URL="tcp://localhost:61616";
    // public static final String QUEUE_NAME="jdbc01";
    public static final String QUEUE_NAME="queue01";
    // public static final String QUEUE_NAME="queue_cluster";

    public static void main(String[] args) throws JMSException, IOException
    {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        Connection connection = connectionFactory.createConnection();

        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue(QUEUE_NAME);

        MessageConsumer consumer = session.createConsumer(queue);

        /*
        同步阻塞方式（receive()）
        订阅者或接收者调用MessageConsumer的receive()方法来接收消息，receive方法在能接收到消息之前(或超时之前)将一直阻塞
        * */
        // while (true)
        // {
        //
        //     TextMessage message= (TextMessage) consumer.receive(4000);
        //     if (null != message)
        //     {
        //         System.out.println("----消费者接收到消息:" + message.getText());
        //     }else {
        //         break;
        //     }
        // }

        //通过监听的方式来消费
        consumer.setMessageListener(new MessageListener()
        {
            public void onMessage(Message message)
            {
                if (null != message && message instanceof TextMessage)
                {
                    TextMessage textMessage = (TextMessage) message;
                    try
                    {
                        System.out.println("----消费者接收到消息:" + textMessage.getText());
                    } catch (JMSException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

        });

        System.in.read();

        consumer.close();
        session.close();
        connection.close();

        /*
        1.先生产，只启动一号消费者  问题：一号消费者能消费消息吗

        2.先生产，启动一号消费者，再启动二号消费者，问题：二号消费者还能消费消息吗

        3.先启动两个消费者，再生产6条消息，请问，消费情况如何
            轮询，一人一半

         */
    }
}
