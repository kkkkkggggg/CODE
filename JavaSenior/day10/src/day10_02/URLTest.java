package day10_02;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL��ͳһ��Դ��λ������Ӧ�Ż�������ĳһ��Դ��ַ
 *
 * 2.��ʽ��
 * URL�Ļ����ṹ��5������ɣ�
 * <����Э��>://<������>:<�˿ں�>/<�ļ���>#Ƭ����?�����б�
 * ?����:
 * http://192.168.1.100:8080/helloworld/index.jsp#a?username=shkstart&password=123
 * ?#Ƭ��������ê�㣬���翴С˵��ֱ�Ӷ�λ���½�
 * ?�����б��ʽ��������=����ֵ&������=����ֵ....
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
            //?һ��URL�������ɺ��������ǲ��ܱ��ı�ģ�������ͨ����������
            //��������ȡ��Щ���ԣ�
            //?public String getProtocol( ) ��ȡ��URL��Э����
            System.out.println(url.getProtocol());
            //?public String getHost( ) ��ȡ��URL��������
            System.out.println(url.getHost());
            //?public String getPort( ) ��ȡ��URL�Ķ˿ں�
            System.out.println(url.getPort());
            //?public String getPath( ) ��ȡ��URL���ļ�·��
            System.out.println(url.getPath());
            //?public String getFile( ) ��ȡ��URL���ļ���
            System.out.println(url.getFile());
            //?public String getQuery( ) ��ȡ��URL�Ĳ�ѯ��
            System.out.println(url.getQuery());
        }catch(MalformedURLException e)
        {
            e.printStackTrace();
        }




    }
}
