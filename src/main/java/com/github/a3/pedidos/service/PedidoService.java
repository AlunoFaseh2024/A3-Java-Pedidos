package com.github.a3.pedidos.service;

import com.github.a3.pedidos.entity.Pedido;
import com.github.a3.pedidos.entity.enums.StatusPedido;
import com.github.a3.pedidos.repository.PedidoRepository;
import com.github.a3.pedidos.util.CodigoEntregaGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido criarPedido(Pedido pedido) {
        pedido.setStatus(StatusPedido.ABERTO);
        pedido.setDataHora(LocalDateTime.now());
        pedido.setCodigoEntrega(CodigoEntregaGenerator.gerarCodigo());
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizarStatus(Long id, StatusPedido novoStatus) {
        Optional<Pedido> opt = pedidoRepository.findById(id);
        if (opt.isPresent()) {
            Pedido pedido = opt.get();
            pedido.setStatus(novoStatus);
            return pedidoRepository.save(pedido);
        }
        return null;
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
