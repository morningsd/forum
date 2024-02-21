package com.example.forum.service.impl;

import com.example.forum.dao.PostDao;
import com.example.forum.dao.impl.PostDaoImpl;
import com.example.forum.entity.Post;
import com.example.forum.entity.User;
import com.example.forum.service.PostService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@RequestScoped
public class PostServiceImpl implements PostService {

    @Inject
    private PostDao postDao;

    public List<Post> findAll() {
        return postDao.findAll();
    }

    @Transactional
    public void save(Post post) {
        postDao.save(post);
    }

    public Post findById(int postId) {
        return postDao.findById(postId);
    }

    public List<Post> findAllByUser(User user) {
        return postDao.findAllByUser(user);
    }

    public void update(Post newPost) {
        postDao.update(newPost);
    }

    public void delete(int postId) {
        postDao.delete(postId);
    }
}
