package br.com.rhuniverse.service;

import br.com.rhuniverse.model.Funcionario;
import br.com.rhuniverse.repository.FuncionarioRepository;
import java.util.List;

public class FuncionarioService {
    private final FuncionarioRepository repository;
    public FuncionarioService(FuncionarioRepository repository) {
        if (repository == null) throw new IllegalArgumentException("Repositório obrigatório.");
        this.repository = repository;
    }
    public void cadastrar(Funcionario funcionario) {
        if (funcionario == null) throw new IllegalArgumentException("Funcionário obrigatório.");
        if (repository.buscarPorId(funcionario.getId()).isPresent())
            throw new IllegalArgumentException("Já existe funcionário com esse ID.");
        repository.salvar(funcionario);
    }
    public Funcionario buscar(int id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado."));
    }
    public List<Funcionario> listar() { return repository.listarTodos(); }
}
