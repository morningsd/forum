package com.example.forum.controller.page.jsp;

import com.example.forum.controller.annotation.PageAccessor;
import com.example.forum.controller.annotation.PageAccessorType;
import com.example.forum.controller.page.Page;
import com.example.forum.entity.Post;
import com.example.forum.entity.User;
import com.example.forum.service.PostService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@PageAccessor(allowedTo = {PageAccessorType.USER, PageAccessorType.ADMIN})
public class CabinetPage extends Page {

    @Inject
    private PostService postService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        List<Post> userPosts = postService.findAllByUser(user);

        request.setAttribute("userPosts", userPosts);

        request.getRequestDispatcher("/WEB-INF/jsp/CabinetPage.jsp").forward(request, response);
    }
}
