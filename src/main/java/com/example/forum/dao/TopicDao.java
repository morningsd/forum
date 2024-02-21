package com.example.forum.dao;

import com.example.forum.entity.Topic;

import java.util.List;

public interface TopicDao {

    List<Topic> findAll();

    Topic findByName(String name);

    Topic findById(int id);

    void save(Topic topic);

    void update(Topic newTopic);

    void delete(int topicId);
}
