package br.com.rhuniverse.repository;

import br.com.rhuniverse.model.Funcionario;
import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository {
    void salvar(Funcionario funcionario);
    Optional<Funcionario> buscarPorId(int id);
    List<Funcionario> listarTodos();
}
