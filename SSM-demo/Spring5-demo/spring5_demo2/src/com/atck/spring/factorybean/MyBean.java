package com.atck.spring.factorybean;

import com.atck.spring.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;

public class MyBean implements FactoryBean<Course>
{
    //定义返回的bean
    @Override
    public Course getObject() throws Exception
    {
        Course course = new Course();
        course.setCourse("abc");
        return course;
    }

    @Override
    public Class<?> getObjectType()
    {
        return null;
    }

    @Override
    public boolean isSingleton()
    {
        return false;
    }
}
