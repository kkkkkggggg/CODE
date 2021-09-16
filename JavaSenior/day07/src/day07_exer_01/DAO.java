package day07_exer_01;

import java.util.*;

/**
 * @acthor KKKKK
 * @creay 2021-04-23-{TIME}
 */
public class DAO<T>
{
    private Map<String,T> map = new HashMap<>();

    //保存T类型的对象到Map成员变量中
    public void save(String id,T entity)
    {
        map.put(id,entity);
    }

    //从map中获取id对应的对象
    public T get(String id)
    {
        return map.get(id);
    }

    //替换map中key为id的内容，改为entity对象
    public void upDate(String id,T entity)
    {
        if(map.containsKey(id))
        {
            map.put(id,entity);
        }

    }

    //获取所有
    public List<T> list()
    {
        Collection<T> values = map.values();
        List<T> list = new ArrayList();
        list.addAll(values);
        return list;

    }

    //删除指定id对应的对象
    public void delete(String id)
    {
        map.remove(id);

    }

}
