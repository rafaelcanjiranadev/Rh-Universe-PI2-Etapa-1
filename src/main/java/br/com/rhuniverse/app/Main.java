package br.com.rhuniverse.app;

import br.com.rhuniverse.model.FolhaPagamento;
import br.com.rhuniverse.model.Funcionario;
import br.com.rhuniverse.repository.FuncionarioRepositoryMemoria;
import br.com.rhuniverse.service.FolhaPagamentoService;
import br.com.rhuniverse.service.FuncionarioService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

public class Main {
    public static void main(String[] args) {
        FuncionarioService funcionarios = new FuncionarioService(new FuncionarioRepositoryMemoria());
        funcionarios.cadastrar(new Funcionario(1, "Ana Souza", LocalDate.of(1995, 4, 12),
                "Analista de RH", new BigDecimal("3000.00"), true));
        assert funcionarios.listar().size() == 1 : "Deveria existir um funcionário cadastrado.";
        assert funcionarios.buscar(1).getNome().equals("Ana Souza") : "Busca por ID falhou.";

        FolhaPagamento folha = new FolhaPagamento("Ana Souza", YearMonth.of(2026, 10),
                new BigDecimal("3000.00"), new BigDecimal("200.00"), new BigDecimal("150.00"),
                new BigDecimal("250.00"), new BigDecimal("50.00"), new BigDecimal("240.00"));
        FolhaPagamentoService calculadora = new FolhaPagamentoService();
        assert calculadora.calcularVencimentos(folha).compareTo(new BigDecimal("3350.00")) == 0;
        assert calculadora.calcularDescontos(folha).compareTo(new BigDecimal("300.00")) == 0;
        assert calculadora.calcularSalarioLiquido(folha).compareTo(new BigDecimal("3050.00")) == 0;
        assert calculadora.calcularFgts(new BigDecimal("3000.00"), new BigDecimal("0.08"))
                .compareTo(new BigDecimal("240.00")) == 0;

        System.out.println("RH Universe: todos os testes de fumaça passaram.");
        System.out.println("Funcionários cadastrados: " + funcionarios.listar().size());
        System.out.println("Vencimentos: R$ " + calculadora.calcularVencimentos(folha));
        System.out.println("Descontos: R$ " + calculadora.calcularDescontos(folha));
        System.out.println("Salário líquido: R$ " + calculadora.calcularSalarioLiquido(folha));
    }
}
