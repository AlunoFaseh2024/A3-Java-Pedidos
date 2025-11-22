package com.github.a3.pedidos.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties({"produtos"}) // Evita serializar os produtos dentro da categoria
    private Categoria categoria;

    // Exemplo: “P”, “M”, “G”, “1L” — opcional
    private String tamanho;

    private Boolean disponivel = true;
    private Boolean visivel = true;
}