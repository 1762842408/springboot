package com.example.demo.modules.test.service;

import java.util.List;

import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.test.entity.City;
import com.github.pagehelper.PageInfo;

public interface CityService {

	List<City> getCitiesByCountryId(int countryId);
	
	List<City> getCitiesByCountryId2(int countryId);

	PageInfo<City> getCitiesByPage(int currentPage, int pageSize, int countryId);

	Result<City> insertCity(City city);
}