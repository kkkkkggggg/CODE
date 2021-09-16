package day10_02;

import org.junit.Test;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * ʵ��TCP��������
 * ����һ��
 *
 * @acthor KKKKK
 * @creay 2021-04-28-{TIME}
 */
public class TCPTest
{
    //�ͻ���
    @Test
    public void client()
    {
        Socket socket = null;
        OutputStream os = null;
        try
        {
            //1.����Socket����ָ���������˵�ip�Ͷ˿ں�
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);

            //2.��ȡһ��������������������
            os = socket.getOutputStream();

            //3.д�����ݵĲ���
            os.write("�ͻ���".getBytes());
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            //4.��Դ�Ĺر�
            try
            {
                if(os != null)
                os.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                if(socket != null)
                socket.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }


    }

    //�����
    @Test
    public void Server()
    {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try
        {
            //1.�����������˵�Socket��ָ���Լ��Ķ˿ں�
            ss = new ServerSocket(8899);

            //2.����accept()��ʾ���������ڿͻ��˵�socket
            socket = ss.accept();

            //3.��ȡ������
            is = socket.getInputStream();

            //����������д�����ܻ�����
            //        byte[] buf = new byte[1024];
            //        int len;
            //        while((len = is.read(buf)) != -1)
            //        {
            //           String str = new String(buf,0,len);
            //            System.out.print(str);
            //        }

            //4.��ȡ�������е�����
            baos = new ByteArrayOutputStream();
            byte[] buf = new byte[5];
            int len;
            while((len = is.read(buf)) != -1)
            {
                baos.write(buf,0,len);
            }

            System.out.println(baos.toString());
            System.out.println("�յ���������" + socket.getInetAddress().getHostAddress() + "������");
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            //5.�ر���Դ
            try
            {
                if(baos != null)
                baos.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                if(is != null)
                is.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                if(socket != null)
                socket.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                if(ss != null)
                ss.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }


    }

}
