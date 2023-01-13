package org.example;

import models.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;

public class PedidoDAODB implements PedidoDAO {
    @Override
    public Boolean crearPedido(Pedido pedido) {
        EntityManager em = EntityManagerFactoryUtil.getEmf().createEntityManager();
        em.getTransaction().begin();
        em.persist(pedido);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public Boolean actualizarPedido(Pedido pedido) {
        EntityManager em = EntityManagerFactoryUtil.getEmf().createEntityManager();
        em.getTransaction().begin();
        em.merge(pedido);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public Pedido obtenerPedido(Integer id) {
        EntityManager em = EntityManagerFactoryUtil.getEmf().createEntityManager();
        return em.find(Pedido.class, id);
    }

    @Override
    public Boolean eliminarPedido(Pedido pedido) {
        EntityManager em = EntityManagerFactoryUtil.getEmf().createEntityManager();
        em.getTransaction().begin();
        em.remove(pedido);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public List<Pedido> obtenerListadoPedidos() {
        EntityManager em = EntityManagerFactoryUtil.getEmf().createEntityManager();

        TypedQuery<Pedido> query =
                em.createQuery("SELECT p FROM Pedido p", Pedido.class);

        List<Pedido> listadoPedidos = query.getResultList();
        em.close();

        return listadoPedidos;
    }

    @Override
    public List<Pedido> obtenerPedidosPendientesHoy() {
        EntityManager em = EntityManagerFactoryUtil.getEmf().createEntityManager();
        TypedQuery<Pedido> query =
                em.createQuery("SELECT p FROM Pedido p WHERE p.fecha = CURRENT_DATE AND p.estado = 'Pendiente'", Pedido.class);

        List<Pedido> listadoPedidos = query.getResultList();
        return listadoPedidos;
    }
}
