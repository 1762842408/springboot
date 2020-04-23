package com.example.demo.modules.test.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modules.test.vo.ConfigBean;



@RestController
@RequestMapping("/api/test")
public class TestController {

	
	private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);
			
	@Value("${server.port}")
	private int port;
	@Value("${com.thorn.bird.name}")
	private String name;
	@Value("${com.thorn.bird.age}")
	private int age;
	@Value("${com.thorn.bird.desc}")
	private String desc;
	@Value("${com.thorn.bird.random}")
	private String random;
	
	@Autowired
	private ConfigBean configBean;
	
	@RequestMapping("/log")

	public String logTest() {
		// level: TRACE<DEBUG<INFO<WARN<ERROR
		LOGGER.trace("This is TRACE log");
		LOGGER.debug("This is DEBUG log");
		LOGGER.info("This is INFO log");
		LOGGER.warn("This is WARN log");
		LOGGER.error("This is ERROR log");
		return "this is log test";
	}
	@RequestMapping("/config")
	public String cofigTest() {
		StringBuffer sb  = new StringBuffer();
		sb.append(port).append("----")
		.append(name).append("----")
		.append(age).append("----")
		.append(desc).append("----")
		.append(random).append("----").append("</br>");
		
		sb.append(configBean.getName()).append("----")
		.append(configBean.getAge()).append("----")
		.append(configBean.getDesc()).append("----")
		.append(configBean.getRandom()).append("----");
		
		return sb.toString();
	}
	
	
	
	@RequestMapping("/appDesc")

	public String getAppDesc() {
		return "Hello world,this is spring boot demo";
		
	}
}
