package com.example.forum.controller.page.jsp;

import com.example.forum.controller.annotation.PageAccessor;
import com.example.forum.controller.annotation.PageAccessorType;
import com.example.forum.controller.page.Page;
import com.example.forum.service.PostService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@PageAccessor(allowedTo = {PageAccessorType.ADMIN})
public class DeletePostPage extends Page {

    @Inject
    private PostService postService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postIdParam = request.getParameter("post_id");
        int postId = Integer.parseInt(postIdParam);

        postService.delete(postId);

        response.sendRedirect("/jsp/home");
    }
}
