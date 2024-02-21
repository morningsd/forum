package com.example.forum.service.impl;

import com.example.forum.dao.UserDao;
import com.example.forum.entity.User;
import com.example.forum.service.UserService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }

    public User findByEmailAndPassword(String email, String password) {
        return userDao.findByEmailAndPassword(email, password);
    }
}
