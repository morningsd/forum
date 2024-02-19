package com.example.forum.service;

import com.example.forum.dao.UserDao;
import com.example.forum.entity.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class UserService {

    @Inject
    private UserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }

    public User findByEmailAndPassword(String email, String password) {
        return userDao.findByEmailAndPassword(email, password);
    }
}
