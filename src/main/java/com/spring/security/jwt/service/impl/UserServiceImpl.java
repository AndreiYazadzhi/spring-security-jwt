package com.spring.security.jwt.service.impl;

import com.spring.security.jwt.entity.UserEntity;
import com.spring.security.jwt.repository.UserEntityRepository;
import com.spring.security.jwt.service.UserService;
import java.util.NoSuchElementException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserEntityRepository userEntityRepository;

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userEntityRepository.save(userEntity);
    }

    @Override
    public UserEntity findByLogin(String login) {
        return userEntityRepository.findByLogin(login)
                .orElseThrow(() -> new NoSuchElementException("Can`t find user with login "
                        + login));
    }

    @Override
    public UserEntity findByLoginAndPassword(String login, String password) {
        return userEntityRepository.findByLoginAndPassword(login, password)
                .orElseThrow(() -> new NoSuchElementException("Can`t find user with login "
                        + login + " and password " + password));
    }
}
