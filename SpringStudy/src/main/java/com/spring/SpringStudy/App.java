package com.spring.SpringStudy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.config.Config;
import com.spring.service.Functions;
import com.spring.service.impl.FunctionsImpl;

/**
 * Hello world!
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Config.class)
public class App 
{
	
	@Autowired
	Functions functions;
	
	@Value("${sex}")
	private String sex;
	
	@Test
	public void runRest() {
		functions.getTest1Properties();
		System.out.println("sex:" + sex);
	}
	
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Functions useFun = context.getBean(Functions.class);
        useFun.getTest1Properties();
    }
}
