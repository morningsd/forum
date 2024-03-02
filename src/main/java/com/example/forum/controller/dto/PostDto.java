package com.example.forum.controller.dto;

import com.example.forum.entity.Topic;
import com.example.forum.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PostDto extends AuditableEntityDto {

    private Integer id;

    private String title;

    private String content;

    private Integer votes;

    private Topic topic;

    private UserDto user;

}
