package me.yukun.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDAO {

  private static final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
      .addAnnotatedClass(Product.class).buildSessionFactory();

  public void addProduct(Product product) {
    Session session = factory.openSession();
    session.beginTransaction();
    session.merge(product);
    session.getTransaction().commit();
  }
}
