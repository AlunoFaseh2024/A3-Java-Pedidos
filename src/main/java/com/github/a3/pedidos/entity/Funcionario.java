package com.github.a3.pedidos.entity;

import com.github.a3.pedidos.entity.enums.CargoFuncionario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificador; // Exemplo: H718
    private String nome;
    private String senhaHash;

    @Enumerated(EnumType.STRING)
    private CargoFuncionario cargo;
}
