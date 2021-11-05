package com.atck.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.math.BigDecimal;

/**
 * javabean
 *
 * 定义JavaBean中成员变量所使用的类型
 * 因为每个基本类型都有一个默认值
 *      int ==> 0
 *      boolean ==> false
 * 因此在创建Javabean的时候最好使用包装类型，因为它们有统一的默认值：null，框架能更好的判断字段是否为空
 */

/*
    MybatisPlus会默认使用实体类的类名到数据中找对应的表
 */
//@TableName(value = "tbl_employee")
public class Employee
{
    /**
     * @Table
     *   value：指定表中主键列的列名，如果实体属性名与列名一致，可以省略不指定
     *   type：指定主键策略
     */
//    @TableId(value = "id",type = IdType.AUTO)
    private Integer id ;

    @TableField(value = "last_name")
    private String lastName;
    private String email ;
    private Integer gender ;
    private Integer age ;

    @TableField(exist = false)
    private BigDecimal salary;

    public BigDecimal getSalary()
    {
        return salary;
    }

    public void setSalary(BigDecimal salary)
    {
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Employee{" + "id=" + id + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + ", gender=" + gender + ", age=" + age + ", salary=" + salary + '}';
    }
}
