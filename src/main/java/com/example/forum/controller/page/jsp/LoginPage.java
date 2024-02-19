package com.example.forum.controller.page.jsp;

import com.example.forum.controller.exception.RedirectException;
import com.example.forum.controller.page.Page;
import com.example.forum.entity.User;
import com.example.forum.service.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginPage extends Page {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/LoginPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userService.findByEmailAndPassword(email, password);

        if (user == null) {
            String errorMessage = "Email or password is incorrect";

            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            response.sendRedirect("/jsp/error");
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        response.sendRedirect("/jsp/home");
    }

}
