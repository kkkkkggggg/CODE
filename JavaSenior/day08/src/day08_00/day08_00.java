package day08_00;

import org.junit.Test;
import sun.util.resources.cldr.CalendarData;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * File类的使用
 *
 * 1.File类的一个对象，代表一个文件或一个文件目录（俗称：文件夹）
 * 2.File类声明在java.io包下
 * 3.File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法
 *      并未涉及到写入或读取文件内容的操作，如果需要读取或写入文件内容，必须适用IO流来完成
 * 4.后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的"终点"
 *
 * @acthor KKKKK
 * @creay 2021-04-23-{TIME}
 */
public class day08_00
{
    /*
    如何创建File类的实例
     */

    @Test
    public void test()
    {
        /*

        1.如何创建File类的实例:
        构造器一:File(String filePath)
        构造器二：File(String parentPath,String childPath)
        构造器三：File(File parentPath,String childPath)
        2.
        相对路径：相较于某个路径下，指明的路径
        绝对路径：包含盘符在内的文件或文件目录的路径

        3.路径分隔符
        Windows:\\
        Unix: /
        public File(String pathname)
        以pathname为路径创建File对象，可以是绝对路径或者相对路径，如果
        pathname是相对路径，则默认的当前路径在系统属性user.dir中存储。
         绝对路径：是一个固定的路径,从盘符开始
         相对路径：是相对于某个位置开始
         */
        File file = new File("hello.txt");//相当于当前module
        File file1 = new File("D:\\JavaSenior\\day08\\he.txt");

        System.out.println(file);
        System.out.println(file1);

        //构造器二
        File file2 = new File("D:\\", "JavaSenior");
        System.out.println(file2);

        //构造器三
        File file3 = new File(file2, "hi.txt");
        System.out.println(file3);
    }

    @Test
    public void test1()
    {
        /*
         File类的获取功能
         public String getAbsolutePath()：获取绝对路径
         public String getPath() ：获取路径
         public String getName() ：获取名称
         public String getParent()：获取上层文件目录路径。若无，返回null
         public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
         public long lastModified() ：获取最后一次的修改时间，毫秒值
        如下两个方法适用于文件目录
         public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
         public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
         */

        File file = new File("hello.txt");
        File file1 = new File("D:\\IO\\hi.txt");

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.lastModified());



        System.out.println();

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());



    }

    @Test
    public void teat1()
    {
        File file = new File("D:\\JavaSenior");

        String[] s = file.list();
        for(String str : s)
        {
            System.out.println(str);
        }

        File[] files = file.listFiles();
        for(File f : files)
        {
            System.out.println(f);
        }

    }

    /*
     File类的重命名功能
     public boolean renameTo(File dest):把文件重命名为指定的文件路径
    比如：file.rename(file1)为例
        要想保证返回true，需要file在硬盘中是存在的，且file1不能在硬盘中存在
     */

    @Test
    public void test2()
    {
        File file = new File("hello.txt");
        File file1 = new File("D:\\IO\\hi.txt");

        boolean renameTo = file.renameTo(file1);

        System.out.println(renameTo);
    }

    /*
     File类的判断功能
     public boolean isDirectory()：判断是否是文件目录
     public boolean isFile() ：判断是否是文件
     public boolean exists() ：判断是否存在
     public boolean canRead() ：判断是否可读
     public boolean canWrite() ：判断是否可写
     public boolean isHidden() ：判断是否隐藏

    这些操作对于文件目录同样适用
     */
    @Test
    public void test3()
    {
        File file = new File("hello.txt");

        //public boolean isDirectory()：判断是否是文件目录
        System.out.println(file.isDirectory());

        //public boolean isFile() ：判断是否是文件
        System.out.println(file.isFile());

        //public boolean exists() ：判断是否存在
        System.out.println(file.exists());

        //public boolean canRead() ：判断是否可读
        System.out.println(file.canRead());

        //public boolean canWrite() ：判断是否可写
        System.out.println(file.canWrite());

        //public boolean isHidden() ：判断是否隐藏
        System.out.println(file.isHidden());

        System.out.println("************************");

        File file1 = new File("D:\\IO");
        file1 = new File("D:\\IO1");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
    }

    /*
     File类的创建功能
     public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
     public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。
    如果此文件目录的上层目录不存在，也不创建。
     public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
    注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目
    路径下。

     File类的删除功能
     public boolean delete()：删除文件或者文件夹
    删除注意事项：
    Java中的删除不走回收站。
    要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
     */
    @Test
    public void test4() throws IOException
    {
        File file = new File("hi.txt");
       if(!file.exists())
       {
           file.createNewFile();
           System.out.println("创建成功");
       }else//文件存在
       {
           file.delete();
           System.out.println("删除成功");
       }

       //文件目录的创建
        File file1 = new File("D:\\TEST\\hello.txt");
       if(!file1.exists())
       {
           file1.mkdir();
       }

        System.out.println(file1.exists());

       if((!file1.exists()))
       {
           file1.mkdirs();
       }

        System.out.println(file1.exists());
    }
}
