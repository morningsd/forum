package com.example.forum.controller.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class AuditableEntityDto {

    private String createdBy;

    private Instant createdAt;

    private Instant updatedAt;
}
