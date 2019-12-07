package com.kairos.curso;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Kairosero implements DisposableBean, InitializingBean {
	
	private String nombre;
	
	public Kairosero(){
		this.nombre = "Oscar";
		System.out.println("Hola, desde el ctor.");
	}
	
	public void print() {
		System.out.println("Hola, mi nombre es: " + this.nombre );
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy()");
	}
	
}
