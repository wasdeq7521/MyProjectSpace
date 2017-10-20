package com.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.spring.service.Functions;

@Component
public class FunctionsImpl implements Functions{
	@Autowired
	Environment environment;
	
	public void getTest1Properties() {
		System.out.println("name:" + environment.getProperty("name"));
		System.out.println("from Test1");
	}
}
