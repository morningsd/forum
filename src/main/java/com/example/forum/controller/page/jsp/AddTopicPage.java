package com.example.forum.controller.page.jsp;

import com.example.forum.controller.page.Page;
import com.example.forum.entity.Topic;
import com.example.forum.service.TopicService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddTopicPage extends Page {

    @Inject
    private TopicService topicService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/AddTopicPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Topic topic = Topic.builder()
                .name(name)
                .description(description)
                .createdBy("admin")
                .build();

        topicService.save(topic);

        response.sendRedirect("/jsp/home");
    }
}
