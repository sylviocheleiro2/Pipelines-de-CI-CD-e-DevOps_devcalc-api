package br.com.infnet.dev_calc_1.service;

import org.springframework.stereotype.Service;

@Service // 1. Indica que esta é uma classe de Serviço (Bean do Spring)
public class CalculadoraService
{
    public Long somar(Long a, Long b) {
        return a + b;
    }

    public Long subtrair(Long a, Long b) {
        return a - b;
    }

    public Long multiplicar(Long a, Long b) {
        return a * b;
    }

    public Long dividir(Long a, Long b) {
        if (b == 0) {
            // 2. A lógica de negócio (validação) mora no service.
            throw new IllegalArgumentException("Divisão por zero não é permitida.");
        }
        return a / b;
    }
}