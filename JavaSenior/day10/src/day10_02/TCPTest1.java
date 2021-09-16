package day10_02;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 实现TCP的网络编程
 * 例题2：客户端发送文件给服务端，服务端将文件保存在本地
 *
 * @acthor KKKKK
 * @creay 2021-04-28-{TIME}
 */
public class TCPTest1
{
    @Test
    public void client()
    {
        Socket socket = null;
        FileInputStream fis = null;
        OutputStream os = null;
        try
        {
            InetAddress ia = InetAddress.getByName("127.0.0.1");
            socket = new Socket(ia,6789);


            fis = new FileInputStream(new File("image1.jpg"));

            os = socket.getOutputStream();

            byte[] buf = new byte[1024];
            int len;
            while((len = fis.read(buf)) != -1)
            {
                os.write(buf,0,len);
            }
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
                if(fis != null)
                fis.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                if(os != null)
                os.close();
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
        InputStream is = null;
        FileOutputStream fos = null;
        try
        {
            ss = new ServerSocket(6789);

            socket = ss.accept();

            is = socket.getInputStream();

            fos = new FileOutputStream("day10\\IMAGE.jpg");

            byte[] buf = new byte[1024];
            int len;
            while((len = is.read(buf)) != -1)
            {
                fos.write(buf,0,len);
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
                if(is != null)
                    is.close();
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

        }
    }
}
