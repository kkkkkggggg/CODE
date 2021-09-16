package PropertiesTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @acthor KKKKK
 * @creay 2021-04-22-{TIME}
 */
public class PropertiesTest
{
    //Properties:常用来处理配置文件，key和value都是String类型
    public static void main(String[] args) throws IOException
    {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        properties.load(fis);//加载流对应的文件

        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println("name=" + name + " password=" + password);

        fis.close();
    }

}
