package com.attest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atck.Person;

public class PersonTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		Person bean = context.getBean(Person.class);
		
		System.out.println(bean);
	}

}
