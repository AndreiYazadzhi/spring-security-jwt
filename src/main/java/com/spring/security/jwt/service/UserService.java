package com.spring.security.jwt.service;

import com.spring.security.jwt.entity.UserEntity;

public interface UserService {
    UserEntity findByLogin(String login);

    UserEntity findByLoginAndPassword(String login, String password);

    UserEntity save(UserEntity user);
}
