package br.com.rhuniverse.service;

import br.com.rhuniverse.model.FolhaPagamento;
import java.math.BigDecimal;
import java.time.YearMonth;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FolhaPagamentoServiceTest {
    private final FolhaPagamentoService service = new FolhaPagamentoService();

    private FolhaPagamento criarFolha() {
        return new FolhaPagamento("Ana Souza", YearMonth.of(2026, 10),
                new BigDecimal("3000.00"), new BigDecimal("200.00"),
                new BigDecimal("150.00"), new BigDecimal("250.00"),
                new BigDecimal("50.00"), new BigDecimal("240.00"));
    }

    @Test
    void deveCalcularVencimentos() {
        assertEquals(0, service.calcularVencimentos(criarFolha()).compareTo(new BigDecimal("3350.00")));
    }

    @Test
    void deveCalcularDescontos() {
        assertEquals(0, service.calcularDescontos(criarFolha()).compareTo(new BigDecimal("300.00")));
    }

    @Test
    void deveCalcularSalarioLiquido() {
        assertEquals(0, service.calcularSalarioLiquido(criarFolha()).compareTo(new BigDecimal("3050.00")));
    }

    @Test
    void deveCalcularFgts() {
        assertEquals(0, service.calcularFgts(new BigDecimal("3000.00"), new BigDecimal("0.08"))
                .compareTo(new BigDecimal("240.00")));
    }

    @Test
    void deveRejeitarPercentualDeFgtsInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularFgts(new BigDecimal("3000.00"), new BigDecimal("1.5")));
    }
}
