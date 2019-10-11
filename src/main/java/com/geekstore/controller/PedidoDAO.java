package com.geekstore.controller;

import com.geekstore.model.pedido.Pedido;
import com.geekstore.util.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class PedidoDAO implements DAO {
    @Override
    public Pedido get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            SQLQuery query = session.createSQLQuery("SELECT cod_pedido, vl_total_pedido FROM tb_pedido WHERE cod_pedido = " + id);
            List<Object[]> objects = query.list();
            Pedido pedido = new Pedido();
            for(Object[] o : objects) {
                pedido.setCodigo((int) o[0]);
                pedido.setValorTotal((BigDecimal) o[1]);
            }
            return pedido;
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
            SQLQuery query = session.createSQLQuery("SELECT cod_pedido, vl_total_pedido FROM tb_pedido");
            List<Object[]> objects = query.list();
            List<Pedido> pedidos = new ArrayList<>();
            for(Object[] o : objects) {
                Pedido pedido = new Pedido();
                pedido.setCodigo((int) o[0]);
                pedido.setValorTotal((BigDecimal) o[1]);
                pedidos.add(pedido);
            }
            return pedidos;
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
    public void save(Object pedido) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(pedido);
            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            if(session.getTransaction() != null ) {
                session.getTransaction().rollback();
            }
            System.out.println(e);
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