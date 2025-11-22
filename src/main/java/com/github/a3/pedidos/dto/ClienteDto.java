package com.github.a3.pedidos.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

class ClienteDto {
    private Long id;
    private String nome;
    private String telefone;
}