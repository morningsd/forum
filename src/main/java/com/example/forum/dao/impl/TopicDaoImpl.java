package com.example.forum.dao.impl;

import com.example.forum.dao.TopicDao;
import com.example.forum.entity.Topic;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RequestScoped
public class TopicDaoImpl implements TopicDao {

    @PersistenceContext
    private EntityManager manager;

    public List<Topic> findAll() {
        return manager.createQuery("SELECT t FROM Topic t", Topic.class)
                .getResultList();
    }

    public Topic findByName(String name) {
        return manager.createQuery("SELECT t FROM Topic t WHERE t.name = ?1", Topic.class)
                .setParameter(1, name)
                .getSingleResult();
    }

    public Topic findById(int id) {
        return manager.find(Topic.class, id);
    }

    @Transactional
    public void save(Topic topic) {
        manager.persist(topic);
    }

    @Transactional
    public void update(Topic newTopic) {
        Topic oldTopic = findById(newTopic.getId());
        oldTopic.setName(newTopic.getName());
        oldTopic.setDescription(newTopic.getDescription());
        oldTopic.setPosts(newTopic.getPosts());
    }

    @Transactional
    public void delete(int topicId) {
        Topic topic = manager.find(Topic.class, topicId);
        manager.remove(topic);
    }

}
