package com.atck.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 只有在容器中的组件才有SpringBoot提供的强大功能
 */
@Data
@ToString
@AllArgsConstructor//全参的构造器
@NoArgsConstructor//无参构造器
// @Component
@ConfigurationProperties(prefix = "mycar")
public class Car
{
    private String brand;
    private Integer price;


}
