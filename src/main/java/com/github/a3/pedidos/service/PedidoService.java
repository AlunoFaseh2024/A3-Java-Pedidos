package com.github.a3.pedidos.service;

import com.github.a3.pedidos.entity.*;
import com.github.a3.pedidos.entity.enums.StatusPedido;
import com.github.a3.pedidos.repository.PedidoRepository;
import com.github.a3.pedidos.repository.ClienteRepository;
import com.github.a3.pedidos.repository.EnderecoRepository;
import com.github.a3.pedidos.repository.ProdutoRepository;
import com.github.a3.pedidos.util.CodigoEntregaGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAllWithDetails(); // Usar o método com JOIN FETCH
    }

    public Optional<Pedido> buscarPorId(Long id) {
        Pedido pedido = pedidoRepository.findByIdWithDetails(id);
        return Optional.ofNullable(pedido);
    }

    @Transactional
    public Pedido criarPedido(Pedido pedido) {
        pedido.setStatus(StatusPedido.ABERTO);
        pedido.setDataHora(LocalDateTime.now());
        pedido.setCodigoEntrega(CodigoEntregaGenerator.gerarCodigo());

        if (pedido.getCliente() != null) {
            Cliente cliente = pedido.getCliente();
            
            if (cliente.getEndereco() != null) {
                Endereco enderecoSalvo = enderecoRepository.save(cliente.getEndereco());
                cliente.setEndereco(enderecoSalvo);
            }
            
            Cliente clienteSalvo = clienteRepository.save(cliente);
            pedido.setCliente(clienteSalvo);
        }

        if (pedido.getItens() != null && !pedido.getItens().isEmpty()) {
            double total = 0.0;
            List<ItemPedido> itensProcessados = new ArrayList<>();

            for (ItemPedido item : pedido.getItens()) {
                ItemPedido novoItem = new ItemPedido();
                novoItem.setPedido(pedido);
                
                if (item.getProduto() != null && item.getProduto().getId() != null) {
                    Optional<Produto> produtoOpt = produtoRepository.findById(item.getProduto().getId());
                    if (produtoOpt.isPresent()) {
                        novoItem.setProduto(produtoOpt.get());
                    } else {
                        throw new RuntimeException("Produto não encontrado: " + item.getProduto().getId());
                    }
                }
                
                novoItem.setQuantidade(item.getQuantidade());
                
                if (item.getPrecoUnitario() != null) {
                    novoItem.setPrecoUnitario(item.getPrecoUnitario());
                } else if (novoItem.getProduto() != null) {
                    novoItem.setPrecoUnitario(novoItem.getProduto().getPreco());
                } else {
                    throw new RuntimeException("Preço unitário não especificado para o item");
                }
                
                double subtotal = novoItem.getPrecoUnitario() * novoItem.getQuantidade();
                total += subtotal;
                
                itensProcessados.add(novoItem);
            }
            
            pedido.setItens(itensProcessados);
            pedido.setTotal(total);
        } else {
            pedido.setTotal(0.0);
        }

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