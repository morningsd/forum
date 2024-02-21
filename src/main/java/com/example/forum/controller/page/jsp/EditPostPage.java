package com.example.forum.controller.page.jsp;

import com.example.forum.controller.annotation.PageAccessor;
import com.example.forum.controller.annotation.PageAccessorType;
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

@PageAccessor(allowedTo = {PageAccessorType.ADMIN})
public class EditPostPage extends Page {

    @Inject
    private PostService postService;

    @Inject
    private TopicService topicServiceImpl;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postIdParam = request.getParameter("post_id");
        int postId = Integer.parseInt(postIdParam);

        Post post = postService.findById(postId);
        List<Topic> topicList = topicServiceImpl.findAll();

        request.setAttribute("post", post);
        request.setAttribute("topicList", topicList);

        request.getRequestDispatcher("/WEB-INF/jsp/EditPostPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postIdParam = request.getParameter("post_id");

        int postId = Integer.parseInt(postIdParam);
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String topicName = request.getParameter("topic");

        Topic topic = topicServiceImpl.findByName(topicName);

        Post post = Post.builder()
                .id(postId)
                .title(title)
                .content(content)
                .topic(topic)
                .build();

        postService.update(post);

        response.sendRedirect("/jsp/home");
    }
}
