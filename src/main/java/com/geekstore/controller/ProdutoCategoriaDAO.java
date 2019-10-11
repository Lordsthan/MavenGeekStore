package com.geekstore.controller;

import com.geekstore.model.produto.ProdutoCategoria;
import com.geekstore.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class ProdutoCategoriaDAO implements DAO {
    @Override
    public ProdutoCategoria get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            SQLQuery query = session.createSQLQuery("SELECT cod_produto_categoria, nm_categoria FROM tb_produto_categoria WHERE cod_produto_categoria = " + id);
            List<Object[]> objects = query.list();
            ProdutoCategoria categoria = new ProdutoCategoria();
            for(Object[] o : objects) {
                categoria.setCodigo((int) o[0]);
                categoria.setNome(String.valueOf(o[1]));
            }
            return categoria;
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
            SQLQuery query = session.createSQLQuery("SELECT cod_produto_categoria, nm_categoria FROM tb_produto_categoria");
            List<Object[]> objects = query.list();
            List<ProdutoCategoria> categorias = new ArrayList<>();
            for(Object[] o : objects) {
                ProdutoCategoria c = new ProdutoCategoria();
                c.setCodigo((int) o[0]);
                c.setNome(String.valueOf(o[1]));
                categorias.add(c);
            }
            return categorias;
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