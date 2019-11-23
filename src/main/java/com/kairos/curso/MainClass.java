package com.kairos.curso;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import com.kairos.curso.servlet.DemoServlet;

public class MainClass {

	public static void main(String[] args) throws LifecycleException {

		final Tomcat server = new Tomcat();
		
		Context myContext = server.addContext("", null);
		
		server.setPort(8090);
		
		server.addServlet( myContext, "demoServlet", new DemoServlet());
		myContext.addServletMappingDecoded("/saludo", "demoServlet");
		
		server.start();
		
		/* COMENTARIO: FORMA TRADICIONAL EN JAVA DE CREAR OTRO HILO DE EJECUCIÓN INDEPENDIENTE AL PRINCIPAL */
		/* new Thread() {
			public void run() {
				server.getServer().await();
			}
		}.run(); */
		
		new Thread( () -> server.getServer().await() ).run();
	}

}
