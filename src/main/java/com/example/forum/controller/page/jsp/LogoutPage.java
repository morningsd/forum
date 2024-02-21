package com.example.forum.controller.page.jsp;

import com.example.forum.controller.annotation.PageAccessor;
import com.example.forum.controller.annotation.PageAccessorType;
import com.example.forum.controller.page.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@PageAccessor(allowedTo = {PageAccessorType.NOT_LOGGED, PageAccessorType.USER, PageAccessorType.ADMIN})
public class LogoutPage extends Page {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("/jsp/login");
    }
}
