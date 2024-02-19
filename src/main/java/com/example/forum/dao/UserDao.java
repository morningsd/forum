package com.example.forum.dao;

import com.example.forum.entity.User;
import com.google.common.hash.Hashing;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.nio.charset.StandardCharsets;

@RequestScoped
public class UserDao {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public void save(User user) {
        String password = user.getPassword();
        String hashPassword = hashPassword(password);

        user.setPassword(hashPassword);

        manager.persist(user);
    }

    public User findByEmailAndPassword(String email, String password) {
        return manager.createQuery("SELECT u FROM User u WHERE email = ?1 AND password = ?2", User.class)
                .setParameter(1, email)
                .setParameter(2, hashPassword(password))
                .getSingleResult();
    }

    private String hashPassword(final String passwordToHash) {
        return Hashing.sha256().hashString(passwordToHash, StandardCharsets.UTF_8).toString();
    }
}
