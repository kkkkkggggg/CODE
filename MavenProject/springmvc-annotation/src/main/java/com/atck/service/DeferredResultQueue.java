package com.atck.service;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DeferredResultQueue
{
    private static Queue<DeferredResult<Object>> queue = new ConcurrentLinkedQueue<>();

    public static void save(DeferredResult<Object> deferredResult)
    {
        queue.add(deferredResult);
    }

    public static DeferredResult<Object> get()
    {
        DeferredResult<Object> deferredResult = queue.poll();

        return deferredResult;
    }
}
