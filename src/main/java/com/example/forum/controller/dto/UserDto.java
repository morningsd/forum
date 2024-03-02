package com.example.forum.controller.dto;

import com.example.forum.entity.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private Role role;

    private Set<PostDto> posts;
}
