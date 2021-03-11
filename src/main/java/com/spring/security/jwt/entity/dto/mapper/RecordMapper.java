package com.spring.security.jwt.entity.dto.mapper;

import com.spring.security.jwt.entity.RecordEntity;
import com.spring.security.jwt.entity.dto.request.RecordRequest;
import org.springframework.stereotype.Component;

@Component
public class RecordMapper {
    public RecordEntity fromDto(RecordRequest request) {
        return RecordEntity.builder().description(request.getDescription())
                .isCompleted(request.isCompleted()).build();
    }
}
