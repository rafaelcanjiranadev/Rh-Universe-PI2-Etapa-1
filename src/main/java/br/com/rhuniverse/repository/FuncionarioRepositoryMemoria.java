package br.com.rhuniverse.repository;

import br.com.rhuniverse.model.Funcionario;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FuncionarioRepositoryMemoria implements FuncionarioRepository {
    private final Map<Integer, Funcionario> dados = new LinkedHashMap<>();
    @Override public void salvar(Funcionario f) { dados.put(f.getId(), f); }
    @Override public Optional<Funcionario> buscarPorId(int id) { return Optional.ofNullable(dados.get(id)); }
    @Override public List<Funcionario> listarTodos() { return new ArrayList<>(dados.values()); }
}
