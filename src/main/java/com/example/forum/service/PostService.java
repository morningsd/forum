package com.example.forum.service;

import com.example.forum.dao.PostDao;
import com.example.forum.entity.Post;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@RequestScoped
public class PostService {

    @Inject
    private PostDao postDao;

    public List<Post> findAll() {
        return postDao.findAll();
    }

    @Transactional
    public void save(Post post) {
        postDao.save(post);
    }
}
