package com.example.forum.entity;

public enum Role {
    USER, ADMIN;

    public String getName() {
        return name().toLowerCase();
    }
}
