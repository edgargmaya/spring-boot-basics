package com.kairos.curso;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kairos.curso.config.MainConfigClass;

public class MainClass {
	
	@Configuration
	@Import(MainConfigClass.class)
	public static class MyConfiguration {
		
	}
	
	/*
	 * Nota: Existen varias formas de crear conextos en Spring,
	 * mediante diferentes implementaciones de la Interface @BeanFactory
	 * */
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext( MyConfiguration.class );
		
		context.registerShutdownHook();
		context.close();
		
		ConfigurableApplicationContext con = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
		Kairosero k = con.getBean(Kairosero.class);
		k.print();
		
		con.close();
	}

}
