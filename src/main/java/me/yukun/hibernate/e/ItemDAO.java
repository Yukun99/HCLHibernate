package me.yukun.hibernate.e;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ItemDAO {

  @SuppressWarnings({"unchecked", "deprecation", "rawtypes"})
  public List<Item> list() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createQuery("from Item order by id");
    List<Item> items = query.list();
    session.close();
    return items;
  }

  @SuppressWarnings({"rawtypes", "deprecation"})
  public Item find(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createQuery("from Item where id = :id");
    query.setParameter("id", id);
    Item result = (Item) query.uniqueResult();
    session.close();
    return result;
  }

  @SuppressWarnings({"rawtypes", "deprecation"})
  public void updateItemPriceById(Item item) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createQuery("update Item set price = :price where id = :id");
    query.setParameter("id", item.getId());
    query.setParameter("price", item.getPrice());
    query.executeUpdate();
    session.close();
  }

  @SuppressWarnings({"rawtypes", "deprecation"})
  public void delete(Item item) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createQuery(
        "delete from Item where id = :id");
    query.setParameter("id", item.getId());
    query.executeUpdate();
    session.close();
  }
}