package com.github.a3.pedidos.controller;

import com.github.a3.pedidos.entity.Funcionario;
import com.github.a3.pedidos.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funcionarios")
@CrossOrigin
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listar() {
        return funcionarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Funcionario> buscarPorId(@PathVariable Long id) {
        return funcionarioService.buscarPorId(id);
    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario) {
        return funcionarioService.salvar(funcionario);
    }

    @PostMapping("/login")
    public Funcionario login(@RequestParam String identificador, @RequestParam String senha) {
        return funcionarioService.autenticar(identificador, senha);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        funcionarioService.deletar(id);
    }
}
