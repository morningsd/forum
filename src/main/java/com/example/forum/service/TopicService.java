package com.example.forum.service;

import com.example.forum.entity.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> findAll();

    Topic save(Topic topic);

    Topic findByName(String name);

    Topic findById(int topicId);

    void update(Topic topic);

    void delete(int topicId);
}
