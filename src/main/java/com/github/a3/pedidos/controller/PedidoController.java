package com.github.a3.pedidos.controller;

import com.github.a3.pedidos.entity.Pedido;
import com.github.a3.pedidos.entity.enums.StatusPedido;
import com.github.a3.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> buscarPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id);
    }

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return pedidoService.criarPedido(pedido);
    }

    @PutMapping("/{id}/status")
    public Pedido atualizarStatus(@PathVariable Long id, @RequestParam StatusPedido status) {
        return pedidoService.atualizarStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
    }
}