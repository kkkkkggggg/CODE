package com.ck6.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Father<T>
{
	
	private Class<T> clazz = null;
	{
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType ptype = (ParameterizedType)type;
		
		Type[] types = ptype.getActualTypeArguments();
		
		System.out.println(types[0]);
		
		Type type2 = types[0];
		
		clazz = (Class<T>) type2;
		
		System.out.println(clazz);
		
		
		
		
		
	}
}
