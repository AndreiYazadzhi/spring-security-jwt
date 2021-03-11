package com.spring.security.jwt.security;

import com.spring.security.jwt.entity.UserEntity;
import com.spring.security.jwt.repository.UserEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserEntityRepository userEntityRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userEntityRepository.findByLogin(username).get();
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
    }
}
