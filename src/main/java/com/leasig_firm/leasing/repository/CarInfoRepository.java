package com.leasig_firm.leasing.repository;
import com.leasig_firm.leasing.domain.CarInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.ArrayList;

@Repository
public class CarInfoRepository {

    public ArrayList<CarInfo>getInfoCar(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from CarInfo ");
        ArrayList<CarInfo> list = (ArrayList<CarInfo>) query.getResultList();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return list;

    }
}
