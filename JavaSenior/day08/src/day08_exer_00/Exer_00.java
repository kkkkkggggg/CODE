package day08_exer_00;

import org.junit.Test;

import java.io.File;

/**
 * @acthor KKKKK
 * @creay 2021-04-24-{TIME}
 */
public class Exer_00
{
    @Test
    public void test()
    {
        File file = new File("D:\\TEST\\A");

        if(!file.exists())
        {
            file.mkdir();
            System.out.println("创建成功");
        }

        File file1 = new File("D:\\TEST\\B\\C");
        if(!file1.exists())
        {
            file1.mkdirs();
            System.out.println("创建成功");
        }

        boolean delete = file1.delete();

        if(delete)
        {
            System.out.println("删除成功");
        }

    }


    @Test
    public void test1()
    {
        /*
        判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
         */
        File file = new File("D:\\TEST");

        String[] fileNameArr = file.list();
        String JPG = new String("gpj.");


        for(String s : fileNameArr)
        {
            //自己写的笨方法
//            if(s.length() >= 4)
//            {
//                int length = s.length();
//                if(length >= 4)
//                {
//                    char[] arr = new char[4];
//                    for(int j = 0; j < 4; j++)
//                    {
//                        arr[j] = s.charAt(length - j - 1);
//                    }
//
//                    String string = new String(arr);
//
//                    if(string.equals(JPG))
//                    {
//                        System.out.println(s);
//                    }
//                }
//            }

            //简单的方法，使用String提供的方法：endsWith()
            if(s.endsWith(".jpg"))
            {
                System.out.println(s);
            }

        }

    }

    /*
    遍历指定目录所有文件名称，包括子文件目录中的文件
    拓展1：并计算指定目录占用空间的大小
    拓展2：删除指定文件目录及其下的所有文件
     */
    @Test
    public void test3()
    {
        File file = new File("D:\\TEST");
        File[] files = file.listFiles();
        System.out.println(fileInfo(files, 0));


        File file1 = new File("D:\\TEST1");

        deletFiles(file1);

    }

    public long fileInfo(File[] files,long initialLength)
    {
        for(File file : files)
        {
            if(file.isDirectory())
            {
                initialLength += file.length();
                fileInfo(file.listFiles(),initialLength);
                System.out.println(file.getName());
            }else
            {
                initialLength += file.length();
                System.out.println(file.getName());
            }
        }

        return initialLength;
    }

    public void deletFiles(File file)
    {
        if(!file.exists())
        {
            throw new RuntimeException("文件不存在，无法删除");
        }

        if(file.isDirectory())
        {
            File[] files = file.listFiles();

            for(File f : files)
            {
                deletFiles(f);
            }

            file.delete();

        }else
        {
            file.delete();
        }


    }
}
