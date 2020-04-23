package com.example.demo.modules.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modules.test.entity.Country;
import com.example.demo.modules.test.service.CountryService;

@RestController
@RequestMapping("/api")
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/country")
	public List<Country> getCountryBycountryName(String countryName){
		return countryService.getCountryBycountryName(countryName);
		
	}
}
