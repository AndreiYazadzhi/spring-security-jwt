package com.spring.security.jwt.entity.dto.mapper;

import com.spring.security.jwt.entity.UserEntity;
import com.spring.security.jwt.entity.dto.request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity fromDto(UserRequest request) {
        return UserEntity.builder().login(request.getLogin())
                .password(request.getPassword()).build();
    }
}
