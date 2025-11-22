package com.github.a3.pedidos.dto;

import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

class ItemPedidoDto {
    private Long produtoId;
    private String nome;
    private Integer quantidade;
    private Double precoUnitario;
}