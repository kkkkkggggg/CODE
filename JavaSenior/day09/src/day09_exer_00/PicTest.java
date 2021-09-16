package day09_exer_00;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @acthor KKKKK
 * @creay 2021-04-26-{TIME}
 */
public class PicTest
{
    //图片的加密,加密方法: ^5
    @Test
    public void test()
    {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try
        {
            fis = new FileInputStream("image.jpg");
            fos = new FileOutputStream("image1.jpg");

            byte[] buf = new byte[1024];
            int len;
            while((len = fis.read(buf)) != -1)
            {
                for(int i = 0; i < len; i++)
                {
                    fos.write(buf[i] ^ 5);
                }
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
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
                if(fis != null)
                fis.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }


    //图片的解密，解密方法: ^5
    @Test
    public void testPic()
    {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try
        {
            fis = new FileInputStream("image1.jpg");
            fos = new FileOutputStream("image2.jpg");

            byte[] buf = new byte[1024];
            int len;
            while((len = fis.read(buf)) != -1)
            {
                for(int i = 0; i < len; i++)
                {
                    fos.write(buf[i] ^ 5);
                }
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
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
                if(fis != null)
                    fis.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test1()
    {
        System.out.println(10 ^ 5);
        System.out.println(10 ^ 4);
        System.out.println(10 ^ 1);
        System.out.println(10 ^ 2);
    }
}
