package com.spring.security.jwt.repository;

import com.spring.security.jwt.entity.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordEntityRepository extends JpaRepository<RecordEntity, Long> {
}
