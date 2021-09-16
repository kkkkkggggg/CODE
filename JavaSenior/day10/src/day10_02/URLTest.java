package day10_02;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL：统一资源定位符，对应着互联网的某一资源地址
 *
 * 2.格式：
 * URL的基本结构由5部分组成：
 * <传输协议>://<主机名>:<端口号>/<文件名>#片段名?参数列表
 * ?例如:
 * http://192.168.1.100:8080/helloworld/index.jsp#a?username=shkstart&password=123
 * ?#片段名：即锚点，例如看小说，直接定位到章节
 * ?参数列表格式：参数名=参数值&参数名=参数值....
 *
 * @acthor KKKKK
 * @creay 2021-04-28-{TIME}
 */
public class URLTest
{
    public static void main(String[] args)
    {
        try
        {
            URL url = new URL("http://192.168.1.100:8080/helloworld/index.jsp#a?username=shkstart&password=123");
            //?一个URL对象生成后，其属性是不能被改变的，但可以通过它给定的
            //方法来获取这些属性：
            //?public String getProtocol( ) 获取该URL的协议名
            System.out.println(url.getProtocol());
            //?public String getHost( ) 获取该URL的主机名
            System.out.println(url.getHost());
            //?public String getPort( ) 获取该URL的端口号
            System.out.println(url.getPort());
            //?public String getPath( ) 获取该URL的文件路径
            System.out.println(url.getPath());
            //?public String getFile( ) 获取该URL的文件名
            System.out.println(url.getFile());
            //?public String getQuery( ) 获取该URL的查询名
            System.out.println(url.getQuery());
        }catch(MalformedURLException e)
        {
            e.printStackTrace();
        }




    }
}
