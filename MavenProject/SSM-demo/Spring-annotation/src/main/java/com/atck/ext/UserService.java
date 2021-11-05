package com.atck.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service()
public class UserService
{
    public UserService()
    {

    }

    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event)
    {
        System.out.println("UserVice..监听到的事件" + event);
    }
}
