package com.example.forum.entity;

public enum Role {
    GUEST, USER, ADMIN;

    public String getName() {
        return name().toLowerCase();
    }
}
