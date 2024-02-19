package com.example.forum.dao;

import com.example.forum.entity.Post;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RequestScoped
public class PostDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostDao.class);

    @PersistenceContext
    private EntityManager manager;

    public List<Post> findAll() {
        return manager.createQuery("SELECT p FROM Post p", Post.class)
                .getResultList();
    }

    public Post findById(int id) {
        return manager.find(Post.class, id);
    }

    @Transactional
    public void save(Post post) {
        manager.persist(post);
    }

    @Transactional
    public void update(Post newPost) {
        Post oldPost = findById(newPost.getId());
        oldPost.setTitle(newPost.getTitle());
        oldPost.setContent(newPost.getContent());
    }

}
