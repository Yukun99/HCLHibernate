package me.yukun.hibernate.a;

import java.util.Collections;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class UserDAO {

  public void insert(User user) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(user);
    session.getTransaction().commit();
    session.close();
  }

  @SuppressWarnings("unchecked")
  public List<User> list() {
    List<User> users;
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Query query = session.createQuery("from User");
    users = (List<User>) query.list();
    Collections.sort(users);
    session.getTransaction().commit();
    session.close();
    return users;
  }

  public User find(String id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    User user = (User) session.get(User.class, id);
    session.getTransaction().commit();
    session.close();
    return user;
  }
}
