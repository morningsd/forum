package com.example.forum.controller.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class StaticFilter extends HttpFilter {

    private static final String PATH_TO_SOURCE_STATIC_FILES_DIR = "../../src/main/webapp";

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        String contextPath = request.getContextPath();
        int length = contextPath.length();
        ServletContext context = getServletContext();
        String uri = request.getRequestURI().substring(length);

        String realPath = context.getRealPath("/");
        File file = new File(new File(realPath, PATH_TO_SOURCE_STATIC_FILES_DIR), uri);

        if (!file.isFile()) {
            file = new File(context.getRealPath(uri));
        }

        if (file.isFile()) {
            String mimeType = context.getMimeType(file.getCanonicalPath());
            response.setContentType(mimeType);
            response.setContentLengthLong(file.length());
            Files.copy(file.toPath(), response.getOutputStream());
        } else {
            chain.doFilter(request, response);
        }

    }
}