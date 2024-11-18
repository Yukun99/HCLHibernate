package me.yukun.hibernate.e;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

  private static SessionFactory sessionFactory = null;

  static {
    try {
      Logger log = Logger.getLogger("org.hibernate");
      log.setLevel(Level.OFF);
      System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

      ResourceBundle rb = ResourceBundle.getBundle("oracle");
      Configuration cfg = new Configuration();
      cfg.configure("hibernate.cfg.xml");
      cfg.setProperty("hibernate.connection.url", rb.getString("db.url"));
      cfg.setProperty("hibernate.connection.username", rb.getString("db.username"));
      cfg.setProperty("hibernate.connection.password", rb.getString("db.password"));

      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
      sessionFactory = cfg.buildSessionFactory(serviceRegistry);
    } catch (Throwable ex) {
      System.err.println("SessionFactory creation failed: " + ex);
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}

