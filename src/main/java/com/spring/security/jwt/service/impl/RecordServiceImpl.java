package com.spring.security.jwt.service.impl;

import com.spring.security.jwt.entity.RecordEntity;
import com.spring.security.jwt.repository.RecordEntityRepository;
import com.spring.security.jwt.service.RecordService;
import java.util.NoSuchElementException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecordServiceImpl implements RecordService {
    private final RecordEntityRepository repository;

    @Override
    public void add(RecordEntity record) {
        repository.save(record);
    }

    @Override
    public void update(RecordEntity record) {
        repository.save(record);
    }

    @Override
    public void delete(RecordEntity record) {
        repository.delete(record);
    }

    @Override
    public RecordEntity getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Can`t find record with id " + id));
    }
}
