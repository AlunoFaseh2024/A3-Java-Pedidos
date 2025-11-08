package com.github.a3.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.a3.pedidos.entity.*;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {}