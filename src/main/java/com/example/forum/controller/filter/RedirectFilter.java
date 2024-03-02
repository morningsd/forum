package com.example.forum.controller.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RedirectFilter extends HttpFilter {

    @Override
    protected void doFilter(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain) throws IOException, ServletException {
        String requestURI = request.getRequestURI();
        if ("/".equals(requestURI)) {
            response.sendRedirect("/jsp/home");
            return;
        }

        chain.doFilter(request, response);
    }
}
