package me.yukun.hibernate.c;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public class ItemDAO {

  public void insert(Item item) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(item);
    session.getTransaction().commit();
    session.close();
  }

  public void update(Item item) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.update(item);
    session.getTransaction().commit();
    session.close();
  }

  @SuppressWarnings({"unchecked", "deprecation"})
  public List<Item> list() {
    List<Item> users;
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Criteria criteria = session.createCriteria(Item.class);
    users = criteria.list();
    session.getTransaction().commit();
    session.close();
    return users;
  }

  public Item find(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Item item = (Item) session.get(Item.class, id);
    session.getTransaction().commit();
    session.close();
    return item;
  }

  public void remove(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.delete(find(id));
    session.getTransaction().commit();
    session.close();
  }
}
