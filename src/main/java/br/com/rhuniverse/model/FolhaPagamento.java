package br.com.rhuniverse.model;

import java.math.BigDecimal;
import java.time.YearMonth;

public class FolhaPagamento {
    private final String funcionario;
    private final YearMonth competencia;
    private final BigDecimal salarioBase, horasExtras, beneficios, inss, outrosDescontos, fgts;

    public FolhaPagamento(String funcionario, YearMonth competencia, BigDecimal salarioBase,
            BigDecimal horasExtras, BigDecimal beneficios, BigDecimal inss,
            BigDecimal outrosDescontos, BigDecimal fgts) {
        if (funcionario == null || funcionario.isBlank()) throw new IllegalArgumentException("Funcionário obrigatório.");
        if (competencia == null) throw new IllegalArgumentException("Competência obrigatória.");
        this.funcionario = funcionario;
        this.competencia = competencia;
        this.salarioBase = positivo(salarioBase, "salário base");
        this.horasExtras = positivo(horasExtras, "horas extras");
        this.beneficios = positivo(beneficios, "benefícios");
        this.inss = positivo(inss, "INSS");
        this.outrosDescontos = positivo(outrosDescontos, "outros descontos");
        this.fgts = positivo(fgts, "FGTS");
    }
    private BigDecimal positivo(BigDecimal v, String campo) {
        if (v == null || v.signum() < 0) throw new IllegalArgumentException("Valor inválido para " + campo + ".");
        return v;
    }
    public String getFuncionario() { return funcionario; }
    public YearMonth getCompetencia() { return competencia; }
    public BigDecimal getSalarioBase() { return salarioBase; }
    public BigDecimal getHorasExtras() { return horasExtras; }
    public BigDecimal getBeneficios() { return beneficios; }
    public BigDecimal getInss() { return inss; }
    public BigDecimal getOutrosDescontos() { return outrosDescontos; }
    public BigDecimal getFgts() { return fgts; }
}
