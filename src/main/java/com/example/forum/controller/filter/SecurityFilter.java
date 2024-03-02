package com.example.forum.controller.filter;

import com.example.forum.controller.annotation.PageAccessor;
import com.example.forum.controller.annotation.PageAccessorType;
import com.example.forum.controller.exception.PageNotFoundException;
import com.example.forum.entity.Role;
import com.example.forum.entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecurityFilter extends HttpFilter {

    private static final String SERVLETS_DIRECTORY = "com.example.forum.controller.page.jsp.";

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext().getServletRegistrations();
        Map<String, String> mappingsToClassNames = servletRegistrations.entrySet()
                .stream()
                .flatMap(entry -> {
                    Collection<String> value = entry.getValue().getMappings().stream().filter(mapping -> mapping.startsWith("/jsp/")).toList();
                    String className = entry.getValue().getClassName();
                    return value.stream().map(mapping -> Map.entry(mapping, className));
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        String contextPath = request.getContextPath();
        int length = contextPath.length();
        String requestURI = request.getRequestURI().substring(length);
        String className = mappingsToClassNames.get(requestURI);

        if (className == null) {
            throw new ServletException("Page not found");
        }

        Class<?> clazz;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new PageNotFoundException();
        }

        PageAccessor annotation = clazz.getAnnotation(PageAccessor.class);
        PageAccessorType[] pageAccessorTypes = annotation.allowedTo();

        if (presentAccessorType(pageAccessorTypes, PageAccessorType.NOT_LOGGED)) {
            super.doFilter(request, response, chain);
            return;
        }

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new ServletException("You are not allowed to access this URL :D");
        }
        Role userRole = user.getRole();

        if (presentAccessorType(pageAccessorTypes, PageAccessorType.USER) && ((userRole == Role.USER) || (userRole == Role.ADMIN))) {
            super.doFilter(request, response, chain);
            return;
        }

        if (presentAccessorType(pageAccessorTypes, PageAccessorType.ADMIN) && userRole == Role.ADMIN) {
            super.doFilter(request, response, chain);
            return;
        }

        throw new ServletException("You are not allowed to access this URL :D");
    }

    private boolean presentAccessorType(PageAccessorType[] types, PageAccessorType type) {
        return Arrays.asList(types).contains(type);
    }
}
