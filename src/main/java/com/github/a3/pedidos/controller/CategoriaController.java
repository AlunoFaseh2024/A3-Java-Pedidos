package com.github.a3.pedidos.controller;

import com.github.a3.pedidos.entity.Categoria;
import com.github.a3.pedidos.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> buscarPorId(@PathVariable Long id) {
        return categoriaService.buscarPorId(id);
    }

    @PostMapping
    public Categoria criar(@RequestBody Categoria categoria) {
        return categoriaService.salvar(categoria);
    }

    @PutMapping("/{id}")
    public Categoria atualizar(@PathVariable Long id, @RequestBody Categoria nova) {
        nova.setId(id);
        return categoriaService.salvar(nova);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
    }
}
