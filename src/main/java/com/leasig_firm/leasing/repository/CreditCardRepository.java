package com.leasig_firm.leasing.repository;

import com.leasig_firm.leasing.domain.CreditCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class CreditCardRepository {

    public void createCreditCard(CreditCard creditCard){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(creditCard);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        }
    public void updateCreditCard(CreditCard creditCard){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(creditCard);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
    public void deleteCreditCard(CreditCard creditCard){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(creditCard);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
