package com.example.forum.service;

import com.example.forum.dao.TopicDao;
import com.example.forum.entity.Topic;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class TopicService {

    @Inject
    private TopicDao topicDao;

    public List<Topic> findAll() {
        return topicDao.findAll();
    }

    public void save(Topic topic) {
        topicDao.save(topic);
    }

    public Topic findByName(String name) {
        return topicDao.findByName(name);
    }
}
