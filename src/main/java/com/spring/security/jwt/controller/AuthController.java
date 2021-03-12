package com.spring.security.jwt.controller;

import com.spring.security.jwt.entity.UserEntity;
import com.spring.security.jwt.entity.dto.mapper.UserMapper;
import com.spring.security.jwt.entity.dto.request.UserRequest;
import com.spring.security.jwt.entity.dto.response.AuthResponse;
import com.spring.security.jwt.security.jwt.JwtProvider;
import com.spring.security.jwt.service.UserService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtProvider jwtProvider;
    private final UserMapper mapper;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRequest request) {
        userService.save(mapper.fromDto(request));
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody UserRequest request) {
        UserEntity user = userService.findByLoginAndPassword(request.getLogin(),
                request.getPassword());
        String token = jwtProvider.generateToken(user.getLogin());
        return new AuthResponse(token);
    }
}
