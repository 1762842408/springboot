package com.example.demo.modules.test.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modules.test.entity.City;
import com.example.demo.modules.test.entity.Country;
import com.example.demo.modules.test.service.CityService;
import com.example.demo.modules.test.service.CountryService;

@Controller
@RequestMapping("/test")
public class TestPageController {
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping("/index")
	public String testIndexPage(ModelMap modelMap) {
		String countryName = "China";
		int countryId = 522;
		
		List<Country> country = countryService.getCountryBycountryName(countryName); 
		City city = cityService.getCitiesByCountryId(countryId).get(0);
		List<City> cities = cityService.getCitiesByCountryId(countryId);
		cities = cities.stream().limit(10).collect(Collectors.toList());
		
		modelMap.addAttribute("thymeleafTitle", "thymeleaf Title");
		modelMap.addAttribute("checked", true);
		modelMap.addAttribute("currentNumber", 99);
		modelMap.addAttribute("changeType", "checkbox");
		modelMap.addAttribute("baiduUrl", "http://www.baidu.com");
		modelMap.addAttribute("shopLogo", "http://cdn.duitang.com/uploads"
				+ "/item/201308/13/20130813115619_EJCWm.thumb.700_0.jpeg");
		modelMap.addAllAttributes(country);
		modelMap.addAttribute("city",city);
		modelMap.addAttribute("updateCityUri","/api/city");
		modelMap.addAttribute("cities",cities);
//		modelMap.addAttribute("template", "test/index");
		return "index";
	}
}
