package com.spring.security.jwt.repository;

import com.spring.security.jwt.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByLogin(String login);

    Optional<UserEntity> findByLoginAndPassword(String login, String password);
}
