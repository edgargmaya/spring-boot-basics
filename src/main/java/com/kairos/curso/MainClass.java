package com.kairos.curso;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.kairos.curso.config.MainConfigClass;

public class MainClass {
	
	@Configuration
	@Import(MainConfigClass.class)
	public static class MyConfiguration {
		
	}
	
	public static void main(String[] args) {
		new AnnotationConfigApplicationContext( MyConfiguration.class );
	}

}
