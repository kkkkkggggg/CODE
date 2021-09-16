package day09_00;

import javafx.beans.binding.When;
import org.junit.Test;

import java.io.*;

/**
 * 测试FileInputStream和FileOutputStream的使用
 * 结论：
 * 1.对于文本文件(.txt\.java\.c\.cpp)，使用字符流处理
 * 2.对于非文本文件(.jpg\.mp3\.mp4\.avi\.doc\.ppt)，使用字节流处理
 *
 *
 * @acthor KKKKK
 * @creay 2021-04-26-{TIME}
 */
public class FileInputOutputStreamTest
{
    @Test
    public void test()
    {
        FileInputStream fis = null;
        try
        {
            //1.造文件
            File file = new File("hello.txt");

            //2.造流
            fis = new FileInputStream(file);

            //3.读数据
            byte[] buffer = new byte[5];
            int len;//记录每次读取的字节个数
            while((len = fis.read(buffer)) != -1)
            {
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            //4.关闭资源
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

    /*
    实现对图片的复制操作
     */
    @Test
    public void testFileInputOutputStream()
    {
        //
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try
        {
            File srcFile = new File("image.jpg");
            File destFile = new File("image1.jpg");

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer)) != -1)
            {
                fos.write(buffer,0,len);
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            //
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

    //指定路径下的文件的复制,并返回复制的文件
    public File copyFile(String srcPath,String destPath)
    {
        File dest = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try
        {
            File src = new File(srcPath);
            dest = new File(destPath);

            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);

            byte[] buf = new byte[1024];
            int len;
            while((len = fis.read(buf)) != -1)
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
        return dest;
    }

//    @Test
//    public void testCopyFile()
//    {
//        long start = System.currentTimeMillis();
//
//        File file = copyFile("E:\\BaiduNetdiskDownload\\有熊谷守一在的地方.mp4","E:\\BaiduNetdiskDownload\\ABC.mp4");
//
//        long end = System.currentTimeMillis();
//
//        System.out.println(end - start);
//    }


}
