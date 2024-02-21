package com.example.forum.dao.impl;

import com.example.forum.dao.PostDao;
import com.example.forum.entity.Post;
import com.example.forum.entity.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RequestScoped
public class PostDaoImpl implements PostDao {

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
        oldPost.setTopic(newPost.getTopic());
    }

    public List<Post> findAllByUser(User user) {
        return manager.createQuery("SELECT p FROM Post p WHERE p.user = ?1", Post.class)
                .setParameter(1, user)
                .getResultList();
    }

    @Transactional
    public void delete(int postId) {
        Post post = manager.find(Post.class, postId);
        manager.remove(post);
    }
}
