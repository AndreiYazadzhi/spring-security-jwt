package com.spring.security.jwt.entity.dto.request;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserRequest {
    @NotEmpty
    private String login;
    @NotEmpty
    private String password;
}
