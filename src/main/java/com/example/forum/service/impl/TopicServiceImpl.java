package com.example.forum.service.impl;

import com.example.forum.dao.TopicDao;
import com.example.forum.dao.impl.TopicDaoImpl;
import com.example.forum.entity.Topic;
import com.example.forum.service.TopicService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class TopicServiceImpl implements TopicService {

    @Inject
    private TopicDao topicDao;

    public List<Topic> findAll() {
        return topicDao.findAll();
    }

    public Topic save(Topic topic) {
        topicDao.save(topic);
        return topic;
    }

    public Topic findByName(String name) {
        return topicDao.findByName(name);
    }

    public Topic findById(int topicId) {
        return topicDao.findById(topicId);
    }

    public void update(Topic topic) {
        topicDao.update(topic);
    }

    public void delete(int topicId) {
        topicDao.delete(topicId);
    }
}
