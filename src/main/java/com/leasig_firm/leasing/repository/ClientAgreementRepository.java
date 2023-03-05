package com.leasig_firm.leasing.repository;

import com.leasig_firm.leasing.domain.ClientAgreement;
import com.leasig_firm.leasing.domain.CreditCard;
import com.leasig_firm.leasing.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.lang.reflect.Array;
import java.util.ArrayList;

@Repository
public class ClientAgreementRepository {
    public ArrayList<ClientAgreement> getAllAgreement() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from ClientAgreement ");
        ArrayList<ClientAgreement> list = (ArrayList<ClientAgreement>) query.getResultList();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return list;
    }

    public ClientAgreement getAgreementById(int id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ClientAgreement clientAgreement = session.get(ClientAgreement.class, id);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return clientAgreement;
    }

    public ClientAgreement showDebt(double debt){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ClientAgreement clientAgreement = session.get(ClientAgreement.class, debt);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return clientAgreement;
    }

//    public ClientAgreement payAgreement(ClientAgreement ca, CreditCard cc){
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//}
}