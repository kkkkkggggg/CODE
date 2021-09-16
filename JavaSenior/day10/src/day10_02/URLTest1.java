package day10_02;

import org.junit.Test;
import sun.misc.PostVMInitHook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @acthor KKKKK
 * @creay 2021-04-28-{TIME}
 */
public class URLTest1
{
    public static void main(String[] args)
    {
        HttpURLConnection connection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try
        {
            URL url = new URL("http://img.netbian.com/file/2021/0427/267fc2f785d7ac881430ff3c8a2c5a95.jpg");

            connection = (HttpURLConnection) url.openConnection();

            connection.connect();

            is = connection.getInputStream();

            fos = new FileOutputStream("day10\\beauty.jpg");

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
            //¹Ø±Õ×ÊÔ´
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
            connection.disconnect();
        }



    }

}

