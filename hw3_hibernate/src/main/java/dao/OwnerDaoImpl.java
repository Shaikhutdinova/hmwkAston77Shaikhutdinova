package dao;

import models.Pet;
import models.Owner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class OwnerDaoImpl implements OwnerDao {

    @Override
    public Owner findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Owner.class, id);
    }

    @Override
    public void save(Owner owner) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(owner);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Owner owner) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(owner);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Owner owner) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(owner);
        tx1.commit();
        session.close();
    }

    public Pet findPetById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Pet.class, id);
    }

    public List<Owner> findAll() {
        List<Owner> users = (List<Owner>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Owner").list();
        return users;
    }
}