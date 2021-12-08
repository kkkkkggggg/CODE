package com.atck.admin.mapper;

import com.atck.admin.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper
{
    @Select("select * from city where id = #{id}")
    City getCityById(int id);

    @Insert("insert into city(`name`,`stat`,`country`) values (#{name},#{stat},#{country})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insertCity(City city);

}
