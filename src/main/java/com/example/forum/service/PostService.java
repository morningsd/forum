package com.example.forum.service;

import com.example.forum.entity.Post;
import com.example.forum.entity.User;
import jakarta.transaction.Transactional;

import java.util.List;

public interface PostService {

    List<Post> findAll();

    void save(Post post);

    Post findById(int postId);

    List<Post> findAllByUser(User user);

    void update(Post newPost);

    void delete(int postId);
}
