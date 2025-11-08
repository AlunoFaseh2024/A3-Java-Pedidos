package com.github.a3.pedidos.dto;

import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

class PedidoDto {
    private Long id;
    private String status;
    private String codigoEntrega;
    private Double total;
    private List<ItemPedidoDto> itens;
}