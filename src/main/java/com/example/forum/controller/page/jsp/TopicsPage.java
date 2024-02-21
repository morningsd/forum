package com.example.forum.controller.page.jsp;

import com.example.forum.controller.annotation.PageAccessor;
import com.example.forum.controller.annotation.PageAccessorType;
import com.example.forum.controller.page.Page;
import com.example.forum.entity.Topic;
import com.example.forum.service.TopicService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@PageAccessor(allowedTo = {PageAccessorType.ADMIN})
public class TopicsPage extends Page {

    @Inject
    private TopicService topicService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Topic> topicList = topicService.findAll();

        request.setAttribute("topicList", topicList);

        request.getRequestDispatcher("/WEB-INF/jsp/TopicsPage.jsp").forward(request, response);
    }
}
