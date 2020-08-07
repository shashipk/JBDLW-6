package com.company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Objects;

public class Repository implements IRepository {
    private SessionFactory sessionFactory;

    public void init(){
        sessionFactory = new Configuration()
                .configure("com/company/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    @Override
    public void save(Object object) {
        if(Objects.isNull(sessionFactory)) {
            init();
        }
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (Exception e) { e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public Object get(Class tclass, long id) {
        if(Objects.isNull(sessionFactory)) {
            init();
        }
        Session session = null;
        try {
            session = sessionFactory.openSession();
            return session.get(tclass,id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }

        return null;
    }

    @Override
    public void update(Object object) {
        if(Objects.isNull(sessionFactory)) {
            init();
        }
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(object);
            transaction.commit();
        } catch (Exception e) { e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void delete(Object object) {
        if(Objects.isNull(sessionFactory)) {
            init();
        }
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (Exception e) { e.printStackTrace();
        }finally {
            session.close();
        }
    }


}
