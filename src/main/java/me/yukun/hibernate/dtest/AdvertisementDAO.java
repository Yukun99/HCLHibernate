package me.yukun.hibernate.dtest;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public class AdvertisementDAO {

  public void insert(Advertisement advertisement) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(advertisement);
    session.getTransaction().commit();
    session.close();
  }

  @SuppressWarnings({"unchecked", "deprecation"})
  public List<Advertisement> list() {
    List<Advertisement> ads;
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Criteria criteria = session.createCriteria(Advertisement.class);
    ads = criteria.list();
    session.getTransaction().commit();
    session.close();
    return ads;
  }

  public Advertisement find(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Advertisement ad = (Advertisement) session.get(Advertisement.class, id);
    session.getTransaction().commit();
    session.close();
    return ad;
  }

  public void update(Advertisement advertisement) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.update(advertisement);
    session.getTransaction().commit();
    session.close();
  }
}
