package com.catalogo.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

@WebListener
public class CatalogoEntityManagerFactory implements ServletContextListener {

	private EntityManagerFactory emf;

	@PersistenceContext(unitName = "catalogo")
	private EntityManager em;

	private static final Logger logger = Logger
			.getLogger(CatalogoEntityManagerFactory.class);

	public void contextInitialized(ServletContextEvent event) {

		this.emf = Persistence.createEntityManagerFactory("catalogo");

		event.getServletContext().setAttribute("emf", emf);

		this.createEntityManager();

	}

	public void contextDestroyed(ServletContextEvent event) {

		EntityManagerFactory emf = (EntityManagerFactory) event
				.getServletContext().getAttribute("emf");

		emf.close();

	}

	public EntityManager createEntityManager() {

		if (emf == null) {

			throw new IllegalStateException("Context is not initialized yet.");

		}

		return emf.createEntityManager();

	}
	

}
