package com.atck.activemq;

import com.atck.activemq.produce.Queue_Produce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// @EnableScheduling //开启调度功能
public class SpringbootActivemqApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootActivemqApplication.class, args);
    }

}
