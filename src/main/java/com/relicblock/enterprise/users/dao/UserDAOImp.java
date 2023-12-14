package com.relicblock.enterprise.users.dao;

import com.relicblock.enterprise.users.repositories.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO
{
    private EntityManager entityManager;

    @Autowired
    public UserDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findBySlug(String userSlug) {
        String query = "FROM User u WHERE u.username=:userSlug";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        typedQuery.setParameter("userSlug", userSlug);
        return typedQuery.getSingleResult();
    }

    @Override
    public List<User> findAll() {
        String query = "FROM User";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(String userSlug, String newFirstName) {
        User user = this.findBySlug(userSlug);
        user.setFirstName(newFirstName);
        this.entityManager.merge(user);
    }

    @Override
    @Transactional
    public void delete(String userSlug) {
        String query = "DELETE FROM User u WHERE u.username=:userSlug";
        TypedQuery typedQuery = entityManager.createQuery(query, User.class);
        typedQuery.setParameter("userSlug", userSlug);
        typedQuery.executeUpdate();
    }
}
