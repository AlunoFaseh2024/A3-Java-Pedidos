package com.github.a3.pedidos.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

class AuthResponseDto {
    private String token;
    private String tipoUsuario;
}