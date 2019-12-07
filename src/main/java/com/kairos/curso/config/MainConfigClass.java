package com.kairos.curso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.kairos.curso.bootstrap.TomcatServer;

/*
 * Nota: La Clases anotadas con @Configuration, deben contener @Bean's que serán creado como SpringBeans
 * para vivir dentro del contenedor de Spring, (BeanFactory)
 * */

@Configuration
public class MainConfigClass {
	
	@Bean
	@Conditional(IsTomcatExist.class)
	public TomcatServer TomcatServer() {
		return new TomcatServer();
	}
	
}
