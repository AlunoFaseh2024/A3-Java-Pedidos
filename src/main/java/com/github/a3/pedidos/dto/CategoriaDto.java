package com.github.a3.pedidos.dto;

import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

class CategoriaDto {
    private Long id;
    private String nome;
    private String descricao;
}