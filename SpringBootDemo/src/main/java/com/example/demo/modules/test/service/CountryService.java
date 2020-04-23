package com.example.demo.modules.test.service;

import java.util.List;

import com.example.demo.modules.test.entity.Country;

public interface CountryService {

	List<Country> getCountryBycountryName(String countryName);

}
