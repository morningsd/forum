package com.example.forum.dao;

import com.example.forum.entity.Post;
import com.example.forum.entity.User;
import jakarta.transaction.Transactional;

import java.util.List;

public interface PostDao {

    List<Post> findAll();

    Post findById(int id);

    void save(Post post);

    void update(Post newPost);

    List<Post> findAllByUser(User user);

    void delete(int postId);
}
