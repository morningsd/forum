package com.example.forum.controller.page.jsp;

import com.example.forum.controller.page.Page;
import com.example.forum.entity.Post;
import com.example.forum.entity.Topic;
import com.example.forum.service.PostService;
import com.example.forum.service.TopicService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class AddPostPage extends Page {

    @Inject
    private TopicService topicService;

    @Inject
    private PostService postService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Topic> topicList = topicService.findAll();

        request.setAttribute("topicList", topicList);

        request.getRequestDispatcher("/WEB-INF/jsp/AddPostPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String topicName = request.getParameter("topic");

        Topic topic = topicService.findByName(topicName);

        Post post = Post.builder()
                .title(title)
                .content(content)
                .topic(topic)
                .createdBy("admin")
                .votes(0)
                .build();

        postService.save(post);

        response.sendRedirect("/jsp/home");
    }
}
