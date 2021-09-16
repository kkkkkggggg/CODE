package com.atck.json;

import com.atck.pojo.Person;
import com.atck.pojo.PersonListType;
import com.atck.pojo.PersonMapType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest
{
    //1.2.1、json和javabean的互相转换
    @Test
    public void test()
    {
        Person person = new Person(1,"Person1");
        //创建Gson对象实例
        Gson gson = new Gson();
        //toJson方法可以把java对象转换为json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);
        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println(person1);
    }

    //1.2.2、json和List的互相转换
    @Test
    public void test1()
    {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person(1,"p1"));
        list.add(new Person(2,"p2"));
        list.add(new Person(3,"p3"));
        list.add(new Person(4,"p4"));

        //创建Gson对象实例
        Gson gson = new Gson();

        String listJsonString = gson.toJson(list);
        System.out.println(listJsonString);

        List<Person> list1 = gson.fromJson(listJsonString, new PersonListType().getType());

        System.out.println(list1);
    }

    //1.2.3、json和Map的互相转换
    @Test
    public void test2()
    {
        Map<Integer,Person> map = new HashMap<>();
        map.put(1,new Person(1,"p1"));
        map.put(2,new Person(2,"p2"));
        map.put(3,new Person(3,"p3"));

        //创建Gson对象实例
        Gson gson = new Gson();
        String mapJsonString = gson.toJson(map);
        System.out.println(mapJsonString);

        // Map<Integer,Person> map1 = gson.fromJson(mapJsonString, new PersonMapType().getType());
        Map<Integer,Person> map1 = gson.fromJson(mapJsonString, new TypeToken<HashMap<Integer,Person>>(){}.getType());
        System.out.println(map1);
    }

    @Test
    public void test3()
    {

        // String s2 = "{\"1\":{\"id\":1,\"name\":\"p1\"},\"2\":{\"id\":2,\"name\":\"p2\"},\"3\":{\"id\":3,\"name\":\"p3\"}}";
        // System.out.println(s2);

        String s = "{\"result\":" +  false  + "}";
        System.out.println(s);
    }

    // {"1":{"id":1,"name":"p1"},"2":{"id":2,"name":"p2"},"3":{"id":3,"name":"p3"}}
    // {1=Person{id=1, name='p1'}, 2=Person{id=2, name='p2'}, 3=Person{id=3, name='p3'}}
}
