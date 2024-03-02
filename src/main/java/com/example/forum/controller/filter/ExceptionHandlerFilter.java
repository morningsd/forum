package com.example.forum.controller.filter;

import com.example.forum.controller.exception.PageNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class ExceptionHandlerFilter extends HttpFilter {

    @Override
    protected void doFilter(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain) throws IOException, ServletException {
        try {
            super.doFilter(request, response, chain);
        } catch (Exception e) {
            if (e instanceof PageNotFoundException) {
                response.sendRedirect("/jsp/notFound");
            } else {
//                Throwable rootCause = e;
//                while (rootCause.getCause() != null && rootCause.getCause() != rootCause) {
//                    rootCause = rootCause.getCause();
//                }
//                String rootCauseMessage = rootCause.getMessage();
//                HttpSession session = request.getSession();
//                session.setAttribute("errorMessage", rootCauseMessage);
//                response.sendRedirect("/jsp/error");
                throw e;
            }
        }
    }
}