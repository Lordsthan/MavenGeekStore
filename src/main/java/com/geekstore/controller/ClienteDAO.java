package com.geekstore.controller;

import com.geekstore.model.cliente.Cliente;
import com.geekstore.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class ClienteDAO implements DAO {
    @Override
    public Cliente get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            SQLQuery query = session.createSQLQuery("SELECT cod_cliente, nm_cliente FROM tb_cliente WHERE cod_cliente = " + id);
            List<Object[]> objects = query.list();
            Cliente cliente = new Cliente();
            for(Object[] o : objects) {
                cliente.setCodigo((int) o[0]);
                cliente.setNome(String.valueOf(o[1]));
            }
            return cliente;
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
    public List<Cliente> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            SQLQuery query = session.createSQLQuery("SELECT cod_cliente, nm_cliente FROM tb_cliente");
            List<Object[]> objects = query.list();
            List<Cliente> clientes = new ArrayList<>();
            for(Object[] o : objects) {
                Cliente cliente = new Cliente();
                cliente.setCodigo((int) o[0]);
                cliente.setNome(String.valueOf(o[1]));
                clientes.add(cliente);
            }
            return clientes;
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
    public void save(Object cliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(cliente);
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