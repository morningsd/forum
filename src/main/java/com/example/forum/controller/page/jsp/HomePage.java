package com.example.forum.controller.page.jsp;

import com.example.forum.controller.page.Page;
import com.example.forum.entity.Post;
import com.example.forum.service.PostService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class HomePage extends Page {

    @Inject
    private PostService postService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> postList = postService.findAll();

        request.setAttribute("postList", postList);

        request.getRequestDispatcher("/WEB-INF/jsp/HomePage.jsp").forward(request, response);
    }
}
