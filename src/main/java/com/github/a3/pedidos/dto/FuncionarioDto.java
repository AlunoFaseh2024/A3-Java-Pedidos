package com.github.a3.pedidos.dto;

import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

class FuncionarioDto {
    private Long id;
    private String identificador;
    private String nome;
    private String cargo;
}