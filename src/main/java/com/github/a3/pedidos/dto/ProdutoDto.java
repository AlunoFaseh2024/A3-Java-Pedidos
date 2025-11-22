package com.github.a3.pedidos.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProdutoDto {
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private String categoria;
    private String tamanho;
    private Boolean disponivel;
    private Boolean visivel;
}