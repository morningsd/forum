package com.example.forum.dao;

import com.example.forum.entity.User;

public interface UserDao {

    void save(User user);

    User findByEmailAndPassword(String email, String password);
}
