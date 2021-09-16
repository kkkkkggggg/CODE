package com.atck.utils;

import com.atck.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils
{
    /**
     * 把map中的值注入到对应的Javabean属性中
     * @param map
     * @param t
     */
    public static <T> T copyParamToBean(Map map, T t)
    {
        try
        {

            // System.out.println("注入之前" + t);
            /*
            把所有请求的参数都注入到user对象中
            * */
            BeanUtils.populate(t,map);
            // System.out.println("注入之后" + t);
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }

        return t;
    }

    public static int parseInt(String strInt,int defaultValue)
    {
        try
        {
            return Integer.parseInt(strInt);
        }catch(Exception e)
        {
            // e.printStackTrace();
        }

        return defaultValue;
    }


}
