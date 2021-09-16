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
 * 实现TCP的网络编程
 * 例子一：
 *
 * @acthor KKKKK
 * @creay 2021-04-28-{TIME}
 */
public class TCPTest
{
    //客户端
    @Test
    public void client()
    {
        Socket socket = null;
        OutputStream os = null;
        try
        {
            //1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);

            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();

            //3.写出数据的操作
            os.write("客户端".getBytes());
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            //4.资源的关闭
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

    //服务端
    @Test
    public void Server()
    {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try
        {
            //1.创建服务器端的Socket，指明自己的端口号
            ss = new ServerSocket(8899);

            //2.调用accept()表示接受来自于客户端的socket
            socket = ss.accept();

            //3.获取输入流
            is = socket.getInputStream();

            //不建议这样写，可能会乱码
            //        byte[] buf = new byte[1024];
            //        int len;
            //        while((len = is.read(buf)) != -1)
            //        {
            //           String str = new String(buf,0,len);
            //            System.out.print(str);
            //        }

            //4.读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buf = new byte[5];
            int len;
            while((len = is.read(buf)) != -1)
            {
                baos.write(buf,0,len);
            }

            System.out.println(baos.toString());
            System.out.println("收到了来自于" + socket.getInetAddress().getHostAddress() + "的数据");
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            //5.关闭资源
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
