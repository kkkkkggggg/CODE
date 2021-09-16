package day10_02;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ʵ��TCP��������
 *
 * ����3.3.�ӿͻ��˷����ļ�������ˣ�����˱��浽���ء������ء����ͳɹ�����
 * �ͻ��ˡ����ر���Ӧ�����ӡ�
 *
 * @acthor KKKKK
 * @creay 2021-04-28-{TIME}
 */
public class TCPTest2
{
    @Test
    public void client()
    {
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        try
        {
            InetAddress ia = InetAddress.getByName("127.0.0.1");
            socket = new Socket(ia,8989);

            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            fis = new FileInputStream("image1.jpg");

            //д���ļ�
            byte[] buf = new byte[1024];
            int len;
            while((len = fis.read(buf)) != -1)
            {
                outputStream.write(buf,0,len);
            }

            //�ر����ݵ��������Ȼ�������˲���֪��ʲôʱ��ֹͣ�������ݣ��޷�ִ������Ĳ���
            socket.shutdownOutput();

            //��ȡ�������˴�����������ݲ����������̨

            baos = new ByteArrayOutputStream();
            while((len = inputStream.read(buf)) != -1)
            {
                baos.write(buf,0,len);
            }
            System.out.println(baos.toString());

        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
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
                if(inputStream != null)
                inputStream.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                if(outputStream != null)
                outputStream.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                if(fis != null)
                fis.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                if(baos != null)
                baos.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args)
    {
        ServerSocket ss = null;
        Socket socket = null;
        FileOutputStream fos = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try
        {
            ss = new ServerSocket(8989);
            socket = ss.accept();

            fos = new FileOutputStream("day10\\IMAGEX.jpg");

            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            byte[] buf = new byte[1024];
            int len;
            while((len = inputStream.read(buf)) != -1)
            {
                fos.write(buf,0,len);
            }



            if(new File("day10\\IMAGEX.jpg").exists())
            {
                outputStream.write("���ͳɹ�".getBytes());
            }


        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                if(ss != null)
                ss.close();
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
                if(fos != null)
                fos.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                if(inputStream != null)
                inputStream.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                if(outputStream != null)
                outputStream.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }


    }

}
