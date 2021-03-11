package com.spring.security.jwt.service;

import com.spring.security.jwt.entity.RecordEntity;

public interface RecordService {
    void add(RecordEntity record);

    void update(RecordEntity record);

    void delete(RecordEntity record);

    RecordEntity getById(Long id);
}
