package com.atck.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value = {"prod","default"})
@Data
@Component
@ConfigurationProperties("person")
public class Boss implements Person
{
    private String name;
    private Integer age;
    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public Integer getAge()
    {
        return age;
    }
}
