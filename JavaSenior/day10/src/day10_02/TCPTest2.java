package day10_02;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 实现TCP的网络编程
 *
 * 例题3.3.从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给
 * 客户端。并关闭相应的连接。
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

            //写出文件
            byte[] buf = new byte[1024];
            int len;
            while((len = fis.read(buf)) != -1)
            {
                outputStream.write(buf,0,len);
            }

            //关闭数据的输出，不然服务器端不会知道什么时候停止读入数据，无法执行下面的操作
            socket.shutdownOutput();

            //读取服务器端传输回来的数据并输出到控制台

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
                outputStream.write("发送成功".getBytes());
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
