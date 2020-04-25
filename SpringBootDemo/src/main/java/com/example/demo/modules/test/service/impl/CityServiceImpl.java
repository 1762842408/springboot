package com.example.demo.modules.test.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.common.vo.Result.ResultEnum;
import com.example.demo.modules.test.dao.CityDao;
import com.example.demo.modules.test.entity.City;
import com.example.demo.modules.test.service.CityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao cityDao;
	
	@Override
	public List<City> getCitiesByCountryId(int countryId) {
		List<City> cities = cityDao.getCitiesByCountryId(countryId);
		return cities;
	}

	@Override
	public List<City> getCitiesByCountryId2(int countryId) {
		List<City> cities2 = cityDao.getCitiesByCountryId2(countryId);
		return cities2;
	}

	@Override
	public PageInfo<City> getCitiesByPage(int currentPage, int pageSize, int countryId) {
		PageHelper.startPage(currentPage,pageSize);
		List<City> cities3 = cityDao.getCitiesByCountryId(countryId);
		return new PageInfo<City>(cities3);
	}

	@Override
	public Result<City> insertCity(City city) {
		Result<City> result = new Result<City>(ResultEnum.SUCCESS.status,"Insert success.");
		try{
			cityDao.insertCity(city);
			result.setObject(city);
		}catch(Exception e){
			result.setStatus(ResultEnum.FAILD.status);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
	@Transactional
	public Result<City> updateCity(City city) {
		Result<City> result = new Result<City>(ResultEnum.SUCCESS.status,"Update success.");
		
			cityDao.updateCity(city);
			result.setObject(city);
			
			return result;
	}

	@Override
	public Result<Object> deleteCity(int cityId) {
		Result<Object> result = new Result<>(ResultEnum.SUCCESS.status,"Delete success.");
		try{
			cityDao.deleteCity(cityId);
		}catch(Exception e) {
			result.setStatus(ResultEnum.FAILD.status);
			result.setMessage(e.getMessage());
		}
		return result;
	}
	

}
