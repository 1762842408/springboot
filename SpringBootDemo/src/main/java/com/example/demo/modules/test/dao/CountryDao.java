
package com.example.demo.modules.test.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.modules.test.entity.Country;

@Mapper
public interface CountryDao {

	@Select("select * from m_country where country_name = #{countryName}")
	List<Country> getCountryBycountryName(String countryName);
	
}
