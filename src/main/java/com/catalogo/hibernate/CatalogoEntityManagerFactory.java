package com.catalogo.hibernate;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CatalogoEntityManagerFactory implements ServletContextListener {

  private EntityManagerFactory emf;

  private EntityManager em;

  public void contextInitialized(ServletContextEvent event) {

    this.emf = Persistence.createEntityManagerFactory("catalogo");

    event.getServletContext().setAttribute("emf", emf);

    this.createEntityManager();

  }

  public void contextDestroyed(ServletContextEvent event) {

    EntityManagerFactory emf = (EntityManagerFactory) event.getServletContext().getAttribute("emf");

    emf.close();

  }

  @Produces
  public void createEntityManager() {

    if (emf == null) {

      throw new IllegalStateException("Context is not initialized yet.");

    }

    this.em = emf.createEntityManager();

  }

}
