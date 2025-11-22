package com.github.a3.pedidos.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

class LoginDto {
    private String identificador;
    private String senha;
}