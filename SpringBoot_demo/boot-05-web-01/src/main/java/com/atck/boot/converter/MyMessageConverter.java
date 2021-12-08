package com.atck.boot.converter;

import com.atck.boot.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.List;

public class MyMessageConverter implements HttpMessageConverter<Person>
{


    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType)
    {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType)
    {
        return clazz.isAssignableFrom(Person.class);
    }

    /**
     * 服务器要统计所有messageConverter都能写出哪些类型
     * <p>
     * application/x-atck
     *
     * @return
     */
    @Override
    public List<MediaType> getSupportedMediaTypes()
    {
        return MediaType.parseMediaTypes("application/x-atck");
    }

    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException
    {
        return null;
    }

    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException
    {
        //自定义数据的写出
        String data = person.getUserName() + ";" + person.getAge() + ";" + person.getBirth();

        //写出去
        outputMessage.getBody().write(data.getBytes());

    }
}
