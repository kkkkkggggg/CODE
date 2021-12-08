package com.atck.admin.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Endpoint(id = "myService")
public class MyServiceEndPoint
{
    @ReadOperation
    public Map getDockerInfo()
    {
        //端点的读操作
        return Collections.singletonMap("dockerInfo","docker started....");
    }

    @WriteOperation
    public void stop()
    {
        System.out.println("docker stopped....");
    }
}
