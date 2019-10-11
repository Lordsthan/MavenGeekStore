package com.geekstore.controller;

import com.geekstore.model.produto.Produto;
import com.geekstore.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class ProdutoDAO implements DAO {
    @Override
    public Object get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            SQLQuery query = session.createSQLQuery("SELECT cod_produto, nm_produto FROM tb_produto WHERE cod_produto = " + id);
            List<Object[]> objects = query.list();
            Produto produto = new Produto();
            for(Object[] o : objects) {
                produto.setCodigo((int) o[0]);
                produto.setNome(String.valueOf(o[1]));
            }
            return produto;
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
            SQLQuery query = session.createSQLQuery("SELECT cod_produto, nm_produto FROM tb_produto");
            List<Object[]> objects = query.list();
            List<Produto> produtos = new ArrayList<>();
            for(Object[] o : objects) {
                Produto produto = new Produto();
                produto.setCodigo((int) o[0]);
                produto.setNome(String.valueOf(o[1]));
                produtos.add(produto);
            }
            return produtos;
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
    public void save(Object produto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(produto);
            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            if(session.getTransaction() != null ) {
                session.getTransaction().rollback();
            }
        }
        finally {
            // session.flush();
            session.close();
        }
    }

    @Override
    public void update(Object t, String[] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}