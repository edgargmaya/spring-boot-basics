package com.kairos.curso.bootstrap;

import javax.annotation.PostConstruct;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import com.kairos.curso.servlet.DemoServlet;

public class TomcatServer {
	
	/*
	 * Nota: Utilizamos la notación lambda introducida en Java 8 para la creación del hilo
	 */
	
	@PostConstruct
	public void start() throws LifecycleException {
		
		final Tomcat server = new Tomcat();
		Context myContext = server.addContext("", null);

		server.setPort(8090);

		Tomcat.addServlet(myContext, "demoServlet", new DemoServlet());
		myContext.addServletMappingDecoded("/saludo", "demoServlet");

		server.start();
		
		new Thread(() -> server.getServer().await()).run();
		
//		new Thread() {
//			public void run() {
//				server.getServer().await();
//			}
//		}.run();
		
	}

}
