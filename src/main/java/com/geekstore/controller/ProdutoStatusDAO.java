package com.geekstore.controller;

import com.geekstore.model.produto.ProdutoStatus;
import com.geekstore.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class ProdutoStatusDAO implements DAO {
    
    @Override
    public ProdutoStatus get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            SQLQuery query = session.createSQLQuery("SELECT cod_produto_status, nm_status FROM tb_produto_status WHERE cod_produto_status = " + id);
            List<Object[]> objects = query.list();
            ProdutoStatus status = new ProdutoStatus();
            for(Object[] o : objects) {
                status.setCodigo((int) o[0]);
                status.setNome(String.valueOf(o[1]));
            }
            return status;
        }
        catch (HibernateException e) {
            System.out.println(e);
        }
        finally {
            session.flush();
            session.close();
        }
        return null;
    }

    @Override
    public List getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            SQLQuery query = session.createSQLQuery("SELECT cod_produto_status, nm_status FROM tb_produto_status");
            List<Object[]> objects = query.list();
            List<ProdutoStatus> statuses = new ArrayList<>();
            for(Object[] o : objects) {
                ProdutoStatus status = new ProdutoStatus();
                status.setCodigo((int) o[0]);
                status.setNome(String.valueOf(o[1]));
                statuses.add(status);
            }
            return statuses;
        }
        catch (HibernateException e) {
            System.out.println(e);
        }
        finally {
            session.flush();
            session.close();
        }
        return null;
    }

    @Override
    public void save(Object categoria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(categoria);
            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            if(session.getTransaction() != null ) {
                session.getTransaction().rollback();
            }
        }
        finally {
            session.flush();
            session.close();
        }
    }

    @Override
    public void update(Object t, String[] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}