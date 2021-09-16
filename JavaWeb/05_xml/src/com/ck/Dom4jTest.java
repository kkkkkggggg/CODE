package com.ck;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class Dom4jTest
{

    @Test
    public void test() throws DocumentException
    {
           //创建一个SAXReader输入流，去读取xml配置文件，生产Document对象
           SAXReader reader = new SAXReader();
           Document document = reader.read("src/books.xml");


    }

    /*
    读取books.xml文件，生成book类
     */
    @Test
    public void test1() throws Exception
    {
        //1.读取books.xml文件
        SAXReader reader = new SAXReader();
        //在junit测试中，相对路径从模块名开始算
        Document document = reader.read("src/books.xml");
        //2.通过document对象获取根元素
        Element root = document.getRootElement();
//        System.out.println(root);
        //3.通过根元素获取book标签对象
        //element()和elements()都是通过标签名查找子元素
        List<Element> books = root.elements("book");
        //4.遍历，处理每个book标签转化为book类
        for (Element book : books)
        {
            //asXML()把标签对象转化为标签字符串
            Element nameElement = book.element("name");
            //getText()可以获取标签中的文本内容
            String nameText = nameElement.getText();
            //直接获取指定标签名的文本内容
            String priceText = book.elementText("price");
            String authorText = book.elementText("author");
            String snValue = book.attributeValue("sn");
            System.out.println(new Book(snValue,nameText,authorText,Double.parseDouble(priceText)));
        }
    }

}
