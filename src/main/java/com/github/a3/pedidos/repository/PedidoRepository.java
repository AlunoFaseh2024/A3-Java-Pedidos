package com.github.a3.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.a3.pedidos.entity.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
    @Query("SELECT p FROM Pedido p LEFT JOIN FETCH p.cliente c LEFT JOIN FETCH c.endereco LEFT JOIN FETCH p.itens i LEFT JOIN FETCH i.produto")
    List<Pedido> findAllWithDetails();
    
    @Query("SELECT p FROM Pedido p LEFT JOIN FETCH p.cliente c LEFT JOIN FETCH c.endereco WHERE p.id = :id")
    Pedido findByIdWithDetails(@Param("id") Long id);
    

}