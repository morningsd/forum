package com.example.forum.controller.page.jsp;

import com.example.forum.controller.annotation.PageAccessor;
import com.example.forum.controller.annotation.PageAccessorType;
import com.example.forum.controller.page.Page;
import com.example.forum.service.TopicService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@PageAccessor(allowedTo = {PageAccessorType.ADMIN})
public class DeleteTopicPage extends Page {

    @Inject
    private TopicService topicService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String topicIdParam = request.getParameter("topic_id");
        int topicId = Integer.parseInt(topicIdParam);

        topicService.delete(topicId);

        response.sendRedirect("/jsp/topics");
    }
}
