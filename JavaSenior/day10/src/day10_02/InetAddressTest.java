package day10_02;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * һ������������������Ҫ�����⣺
 * ?���׼ȷ�ض�λ������һ̨���̨��������λ�����ϵ��ض���Ӧ��
 * ?�ҵ���������οɿ���Ч�ؽ������ݴ���
 *
 * �����������е�����Ҫ��
 * ��Ӧ����һ��IP�Ͷ˿ں�
 * ��Ӧ��������ṩ����ͨ��Э�飺TCP/IP�ο�ģ��(Ӧ�ò㡢����㡢����㡢����+������·��)
 *
 * ����ͨ��Ҫ��һ��IP�Ͷ˿ں�
 *
 * 1.IP��Ψһ�ı�ʶInternet�ϵļ������ͨ��ʵ�壩
 * 2.��Java��ʹ��InetAddress�����IP
 * 3.IP���ࣺIPv4 �� IPv6 ; ��ά���;�����
 * 4.������www.baidu.com
 * 5.���ػ�·��ַ��127.0.0.1  ��Ӧ�ţ�Localhost
 * 6.���ʵ����InetAddress������������getByNmae(String host)��getLocalHost()
 *          �������÷�����getHostName()/getHostAddress()
 * 7.�˿ںţ����ڼ���������еĽ���
 * Ҫ�󣺲�ͣ�Ľ����в�ͬ�Ķ˿ں�
 * ��Χ�����涨Ϊһ��16λ���� 0~65535.
 *
 * 8.�˿���IP��ַ����ϵó�һ�������׽��֣�Socket
 *
 *
 * @acthor KKKKK
 * @creay 2021-04-28-{TIME}
 */
public class InetAddressTest
{
    public static void main(String[] args)
    {
        try
        {
            //File file = new File("hello.txt");
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            //��ȡ����ip
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

            //getHostName()
            System.out.println(inet2.getHostName());

            //getHostAddress()
            System.out.println(inet2.getHostAddress());
        }catch(UnknownHostException e)
        {
            e.printStackTrace();
        }
    }
}
