package day10_00;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1.ObjectInputStream 和 ObjectOutputStream
 * 2.作用：用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可
 * 以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 *
 * 3.要想一个java对象是可序列化的，需要满足相应的要求，见Person类
 *
 * 4.序列化机制
 * 对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从
 * 而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传
 * 输到另一个网络节点。//当其它程序获取了这种二进制流，就可以恢复成原
 * 来的Java对象 
 *
 * @acthor KKKKK
 * @creay 2021-04-27-{TIME}
 */
public class ObjectInputOutputStream
{
    /*
    序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void test()
    {
        ObjectOutputStream oos = null;
        try
        {
            //1.
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));

            //2.
            oos.writeObject(new String("ABCDEFG"));
            oos.flush();//刷新操作

            oos.writeObject(new Person("网名",23));
            oos.flush();
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            //3.
            try
            {
                if(oos != null)
                oos.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }


    /*
    反序列化：将磁盘文件中的对象还原为内存中的一个java对象
    使用ObjectInputStream实现
     */
    @Test
    public void test1()
    {
        ObjectInputStream ois = null;
        try
        {
            //1.
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            //2.
//            String str = (String) ois.readObject();

//            System.out.println(str);

            System.out.println(ois.readObject());

            System.out.println(ois.readObject());
        }catch(IOException e)
        {
            e.printStackTrace();
        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }finally
        {
            //3.
            try
            {
                if(ois != null)
                ois.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }

    }

}
