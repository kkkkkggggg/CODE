package com.atck.mp.metaobjecthandler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * 自定义公共字段处理器
 */
public class MyMetaObjectHandler extends MetaObjectHandler
{

    /**
     * 插入操作，自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject)
    {
        //获取到需要被填充的字段的值
        Object fieldValue = getFieldValByName("name",metaObject);

        if (fieldValue == null)
        {
            System.out.println("************插入操作，满足填充条件***************");
            setFieldValByName("name","kkkkk",metaObject);
        }
    }

    /**
     * 修改操作，自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject)
    {
        //获取到需要被填充的字段的值
        Object fieldValue = getFieldValByName("name",metaObject);

        if (fieldValue == null)
        {
            System.out.println("************修改操作，满足填充条件***************");
            setFieldValByName("name","kkkkk",metaObject);
        }
    }
}
