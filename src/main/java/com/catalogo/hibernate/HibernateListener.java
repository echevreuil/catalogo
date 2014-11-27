package com.catalogo.hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class HibernateListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("catalogo");
		event.getServletContext().setAttribute("emf", emf);

	}

	public void contextDestroyed(ServletContextEvent event) {
		EntityManagerFactory emf = (EntityManagerFactory) event.getServletContext()
				.getAttribute("emf");
		emf.close();
	}
}
