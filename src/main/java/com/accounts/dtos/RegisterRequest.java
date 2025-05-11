package com.accounts.dtos;

import lombok.*;

@Getter @Setter
public class RegisterRequest {
    private String username;
    private String password;
}
