package com.atck.boot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


/**
 * 主程序类
 * @SpringBootApplication ：这是一个SpringBoot应用
 */
@SpringBootApplication
// @SpringBootConfiguration
// @EnableAutoConfiguration
// @ComponentScan("com.atck")
public class MainApplication
{
    public static void main(String[] args)
    {
        // //1.返回我们的ioc容器
        // ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //
        // //2.查看容器中的组件
        // String[] beanDefinitionNames = run.getBeanDefinitionNames();
        // for (String s : beanDefinitionNames)
        // {
        //     System.out.println(s);
        // }
        //
        // // //3.从容器中获取组件
        // // User user = run.getBean("user01",User.class);
        // // Pet pet = run.getBean(Pet.class);
        // //
        // // System.out.println(user);
        // // System.out.println(pet);
        // //
        // // //com.atck.boot.config.MyConfig$$EnhancerBySpringCGLIB$$f296f383@43d455c9
        // // MyConfig myConfig = run.getBean("myConfig", MyConfig.class);
        // //
        // // System.out.println(myConfig);
        // //
        // // //4.@Configuration(proxyBeanMethods = true)代理对象调用方法，SpringBoot总会检查这个组件是否在容器中有
        // // //保持组件单实例
        // // User user1 = myConfig.user01();
        // // User user2 = myConfig.user01();
        // // System.out.println(user1 == user2);
        // //
        // //
        // // User user3 = run.getBean("user01",User.class);
        // //
        // // System.out.println(pet == user3.getPet());
        // //
        // // //5.获取组件
        // // String[] beanNamesForType = run.getBeanNamesForType(User.class);
        // //
        // // for (String name : beanNamesForType)
        // // {
        // //     System.out.println(name);
        // // }
        //
        // boolean tom = run.containsBean("tomcatPet");
        //
        // System.out.println(tom);
        //
        // System.out.println(run.containsBean("user01"));
        //
        // System.out.println("haha:" + run.getBean("haha"));
        // System.out.println("hehe:" + run.getBean("hehe"));
        //
        // System.out.println(run.getBean(Car.class));
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File("src/main/resources/links.xml");
            Document doc = builder.parse(file);
            doc.normalize();
            NodeList links = doc.getElementsByTagName("link");
            for (int i = 0; i < links.getLength(); i++) {
                Element link = (Element) links.item(i);
                System.out.print("Content: ");
                System.out.println(link.getElementsByTagName("text").item(0)
                        .getFirstChild().getNodeValue());
                System.out.print("URL: ");
                System.out.println(link.getElementsByTagName("url").item(0)
                        .getFirstChild().getNodeValue());
                System.out.print("Author: ");
                System.out.println(link.getElementsByTagName("author").item(0)
                        .getFirstChild().getNodeValue());
                System.out.print("Date: ");
                Element linkdate = (Element) link.getElementsByTagName("date")
                        .item(0);
                String day = linkdate.getElementsByTagName("day").item(0)
                        .getFirstChild().getNodeValue();
                String month = linkdate.getElementsByTagName("month").item(0)
                        .getFirstChild().getNodeValue();
                String year = linkdate.getElementsByTagName("year").item(0)
                        .getFirstChild().getNodeValue();
                System.out.println(day + "-" + month + "-" + year);
                System.out.print("Description: ");
                System.out.println(link.getElementsByTagName("description")
                        .item(0).getFirstChild().getNodeValue());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

