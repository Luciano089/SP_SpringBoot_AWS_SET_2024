package com.luciano.demo_park_api.controller.dto;

import lombok.*;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class UserResponseDto {
    private Long id;

    private String username;

    private String role;

}