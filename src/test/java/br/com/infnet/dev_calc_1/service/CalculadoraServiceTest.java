package br.com.infnet.dev_calc_1.service;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraServiceTest {

    private final CalculadoraService calculadoraService = new CalculadoraService();

    @Property
    void somar(@ForAll Long a, @ForAll Long b) {
        Long resultado = calculadoraService.somar(a, b);
        assertEquals(a + b, resultado);
    }

    @Property
    void subtrair(@ForAll Long a, @ForAll Long b) {
        Long resultado = calculadoraService.subtrair(a, b);
        assertEquals(a - b, resultado);
    }

    @Property
    void multiplicar(@ForAll Long a, @ForAll Long b) {
        Long resultado = calculadoraService.multiplicar(a, b);
        assertEquals(a * b, resultado);
    }

    @Property
    void dividir(@ForAll Long a, @ForAll Long b) {
        if (b != 0) {
            Long resultado = calculadoraService.dividir(a, b);
            assertEquals(a / b, resultado);
        }
    }

    @Test
    void dividirPorZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadoraService.dividir(1L, 0L);
        });
    }
}
