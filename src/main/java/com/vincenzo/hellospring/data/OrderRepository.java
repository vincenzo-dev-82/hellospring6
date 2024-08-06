package com.vincenzo.hellospring.data;

import com.vincenzo.hellospring.order.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class OrderRepository {

    private final EntityManagerFactory emf;

    public OrderRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void save(Order order) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            // id가 없었다가
            em.persist(order);
            em.flush();
           // id가 생긴다

            transaction.commit();
        } catch (RuntimeException e) {
            if(transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            if(em.isOpen()) {
                em.close();
            }
        }

    }
}
