package com.github.a3.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.a3.pedidos.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    @Query("SELECT c FROM Cliente c LEFT JOIN FETCH c.endereco WHERE c.id = :id")
    Cliente findByIdWithEndereco(@Param("id") Long id);
}