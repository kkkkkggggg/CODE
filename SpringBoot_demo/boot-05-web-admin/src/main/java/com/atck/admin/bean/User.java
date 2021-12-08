package com.atck.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User
{
    /**
     * 所有属性都应该在数据库中
     */
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String passWord;

    //以下是数据库字段
    private int id;
    private String name;
    private int age;
    private String email;
}
