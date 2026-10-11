package br.com.rhuniverse.service;

import br.com.rhuniverse.model.FolhaPagamento;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class FolhaPagamentoService {
    public BigDecimal calcularVencimentos(FolhaPagamento folha) {
        return folha.getSalarioBase().add(folha.getHorasExtras()).add(folha.getBeneficios())
                .setScale(2, RoundingMode.HALF_UP);
    }
    public BigDecimal calcularDescontos(FolhaPagamento folha) {
        return folha.getInss().add(folha.getOutrosDescontos()).setScale(2, RoundingMode.HALF_UP);
    }
    public BigDecimal calcularSalarioLiquido(FolhaPagamento folha) {
        BigDecimal liquido = calcularVencimentos(folha).subtract(calcularDescontos(folha));
        return liquido.setScale(2, RoundingMode.HALF_UP);
    }
    public BigDecimal calcularFgts(BigDecimal base, BigDecimal percentual) {
        if (base == null || base.signum() < 0 || percentual == null ||
                percentual.signum() < 0 || percentual.compareTo(new BigDecimal("1")) > 0) {
            throw new IllegalArgumentException("Base ou percentual de FGTS inválido.");
        }
        return base.multiply(percentual).setScale(2, RoundingMode.HALF_UP);
    }
}
