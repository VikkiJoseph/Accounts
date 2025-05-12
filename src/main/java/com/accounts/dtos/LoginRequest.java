package com.accounts.dtos;

import lombok.*;

@Getter @Setter
public class LoginRequest {
    private String username;
    private String password;
}