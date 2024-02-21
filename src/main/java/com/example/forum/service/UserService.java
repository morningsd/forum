package com.example.forum.service;

import com.example.forum.entity.User;

public interface UserService {

    void save(User user);

    User findByEmailAndPassword(String email, String password);
}
