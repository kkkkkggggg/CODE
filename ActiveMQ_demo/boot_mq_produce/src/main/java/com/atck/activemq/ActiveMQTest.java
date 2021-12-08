package com.atck.activemq;

import com.atck.activemq.produce.Queue_Produce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

@SpringBootTest(classes = SpringbootActivemqApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ActiveMQTest {
    @Autowired
    private Queue_Produce queue_produce;

    @Test
    public void testSend() throws IOException
    {
        queue_produce.produceMsg();
        System.in.read();
    }
}


