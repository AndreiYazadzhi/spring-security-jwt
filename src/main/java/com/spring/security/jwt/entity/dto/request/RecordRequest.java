package com.spring.security.jwt.entity.dto.request;

import lombok.Data;

@Data
public class RecordRequest {
    private String description;
    private boolean isCompleted;
}
