package com.leasig_firm.leasing.repository;
import com.leasig_firm.leasing.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.ArrayList;

@Repository
public class UserRepository {

    public void createUser(User user) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public void updateUser(User user) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public ArrayList<User> getAllUser() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User");
        ArrayList<User> list = (ArrayList<User>) query.getResultList();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return list;
    }

    public User getUserById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return user;
    }
    public void deleteUser(User user) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
