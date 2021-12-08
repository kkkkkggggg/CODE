package com.atck.admin.service;

import com.atck.admin.bean.City;

public interface CityService
{
    City getCityById(int id);

    void insertCity(City city);
}
