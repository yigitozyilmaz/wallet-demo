package com.example.odev.business.requests;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String name;
    private String email;
    private String password;
}
