package com.github.a3.pedidos.service;

import com.github.a3.pedidos.entity.Funcionario;
import com.github.a3.pedidos.repository.FuncionarioRepository;
import com.github.a3.pedidos.util.HashUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> buscarPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario salvar(Funcionario f) {
        f.setSenhaHash(HashUtils.sha256(f.getSenhaHash())); // Criptografa a senha antes de salvar
        return funcionarioRepository.save(f);
    }

    public Funcionario autenticar(String identificador, String senha) {
        Funcionario f = funcionarioRepository.findByIdentificador(identificador);
        if (f != null && f.getSenhaHash().equals(HashUtils.sha256(senha))) {
            return f;
        }
        return null;
    }

    public void deletar(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
