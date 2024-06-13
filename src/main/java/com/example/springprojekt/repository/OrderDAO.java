package com.example.springprojekt.repository;

import com.example.springprojekt.model.Order;
import com.example.springprojekt.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAO {
    @PersistenceContext
    private EntityManager entityManager;
    private final String GET_ALL_JPQL = "FROM com.example.springprojekt.model.Order";
    private final String GET_BY_USER_JPQL = "SELECT o FROM com.example.springprojekt.model.Order o WHERE o.user = :user";

    public List<Order> getAll() {
        TypedQuery<Order> query = entityManager.createQuery(GET_ALL_JPQL, Order.class);
        return query.getResultList();
    }

    public List<Order> getByUser(User user) {
        TypedQuery<Order> query = entityManager.createQuery(GET_BY_USER_JPQL, Order.class);
        query.setParameter("user", user);
        return query.getResultList();
    }
}
