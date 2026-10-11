package br.com.rhuniverse.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario {
    private final int id;
    private final String nome;
    private final LocalDate dataNascimento;
    private final String cargo;
    private final BigDecimal salarioBase;
    private final boolean ativo;

    public Funcionario(int id, String nome, LocalDate dataNascimento, String cargo,
                       BigDecimal salarioBase, boolean ativo) {
        if (id <= 0) throw new IllegalArgumentException("O ID deve ser positivo.");
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome obrigatório.");
        if (dataNascimento == null) throw new IllegalArgumentException("Data de nascimento obrigatória.");
        if (cargo == null || cargo.isBlank()) throw new IllegalArgumentException("Cargo obrigatório.");
        if (salarioBase == null || salarioBase.signum() < 0) throw new IllegalArgumentException("Salário inválido.");
        this.id = id;
        this.nome = nome.trim();
        this.dataNascimento = dataNascimento;
        this.cargo = cargo.trim();
        this.salarioBase = salarioBase;
        this.ativo = ativo;
    }
    public int getId() { return id; }
    public String getNome() { return nome; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public String getCargo() { return cargo; }
    public BigDecimal getSalarioBase() { return salarioBase; }
    public boolean isAtivo() { return ativo; }
}
