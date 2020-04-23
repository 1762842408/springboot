package com.example.demo.modules.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modules.test.dao.CountryDao;
import com.example.demo.modules.test.entity.Country;
import com.example.demo.modules.test.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryDao countryDao;
	@Override
	public List<Country> getCountryBycountryName(String countryName) {
		List<Country> countries = countryDao.getCountryBycountryName(countryName);
		return countries;
	}



}
