package com.geekstore.controller;

import com.geekstore.model.pedido.Pedido;
import com.geekstore.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ProdutoFotoDAO implements DAO {
    @Override
    public Pedido get(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Object foto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(foto);
            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            if(session.getTransaction() != null ) {
                session.getTransaction().rollback();
            }
            System.out.println(e);
        }
        finally {
            session.close();
        }
    }

    @Override
    public void update(Object t, String[] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}