package com.atck.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nTest
{
    @Test
    public void testLocal()
    {
        Locale locale = Locale.getDefault();
        System.out.println(locale);
        for (Locale availableLocale : Locale.getAvailableLocales())
        {
            System.out.println(availableLocale);
        }

        //获取中文常量的Locale对象
        System.out.println(Locale.CHINA);
    }

    @Test
    public void test2()
    {
        //得到我们需要的Locale对象
        Locale locale = Locale.CHINA;
        //通过指定的basename和Locale对象，读取对应的配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);

        System.out.println("username：" + bundle.getString("username"));
        System.out.println("password：" + bundle.getString("password"));
        System.out.println("sex：" + bundle.getString("sex"));
        System.out.println("age：" + bundle.getString("age"));

    }
}
