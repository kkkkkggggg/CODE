package day07_01;

import java.util.List;

/**
 * @acthor KKKKK
 * @creay 2021-04-22-{TIME}
 */
public class DAO<T>//表的共性操作的DAO
{
    //添加一条记录
     public void add(T t)
        {

        }

    //删除一条记录
    public boolean remove(int index)
    {
        return false;
    }

    //修改一条记录
    public void upDate(int index,T t)
    {

    }


    //查询一条记录
    public T getIndex(int index)
    {
        return null;
    }

    //查询多条记录
    //举例：获取表中一共有多少条元素
    //返回入职最长的员工的入职日期
    public List get(int start,int end)
    {
        return null;
    }

    public <E> E getTotal()
    {
        return null;
    }
}
