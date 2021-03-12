package com.spring.security.jwt.security;

import com.spring.security.jwt.entity.UserEntity;
import com.spring.security.jwt.repository.UserEntityRepository;
import java.util.NoSuchElementException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserEntityRepository userEntityRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) {
        UserEntity userEntity = userEntityRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Can`t find user with login " + username));
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
    }
}
