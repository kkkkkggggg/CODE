package com.atck.admin.service.impl;

import com.atck.admin.bean.City;
import com.atck.admin.mapper.CityMapper;
import com.atck.admin.service.CityService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService
{
    @Autowired
    CityMapper cityMapper;

    Counter counter;

    public CityServiceImpl(MeterRegistry meterRegistry)
    {
         counter = meterRegistry.counter("cityService.insertCity.count");
    }

    public City getCityById(int id)
    {
        return cityMapper.getCityById(id);
    }

    public void insertCity(City city)
    {
        counter.increment();
        cityMapper.insertCity(city);
    }
}
