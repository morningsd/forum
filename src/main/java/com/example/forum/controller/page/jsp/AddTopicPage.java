package com.example.forum.controller.page.jsp;

import com.example.forum.controller.annotation.PageAccessor;
import com.example.forum.controller.annotation.PageAccessorType;
import com.example.forum.controller.page.Page;
import com.example.forum.entity.Topic;
import com.example.forum.entity.User;
import com.example.forum.service.TopicService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@PageAccessor(allowedTo = {PageAccessorType.ADMIN})
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

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        Topic topic = Topic.builder()
                .name(name)
                .description(description)
                .createdBy(user.getFirstName() + " " + user.getLastName())
                .build();

        topicService.save(topic);

        response.sendRedirect("/jsp/home");
    }
}
