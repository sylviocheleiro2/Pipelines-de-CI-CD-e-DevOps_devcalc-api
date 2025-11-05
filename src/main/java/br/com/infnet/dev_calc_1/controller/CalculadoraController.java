package br.com.infnet.dev_calc_1.controller;

import br.com.infnet.dev_calc_1.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 1. Marca a classe como um Controller REST
public class CalculadoraController
{
    // 2. Injeta a dependência do nosso service
    @Autowired
    private CalculadoraService calculadoraService;

    // 3. Mapeia o GET para /add
    //    URL: /add?a=10&b=5
    @GetMapping("/add")
    public Long adicionar(@RequestParam Long a, @RequestParam Long b) {
        // 4. @RequestParam "a" é ligado ao parâmetro Long a
        //    @RequestParam "b" é ligado ao parâmetro Long b
        return calculadoraService.somar(a, b);
    }

    // URL: /subtract?a=10&b=5
    @GetMapping("/subtract")
    public Long subtrair(@RequestParam Long a, @RequestParam Long b) {
        return calculadoraService.subtrair(a, b);
    }

    // URL: /multiply?a=10&b=5
    @GetMapping("/multiply")
    public Long multiplicar(@RequestParam Long a, @RequestParam Long b) {
        return calculadoraService.multiplicar(a, b);
    }

    // URL: /divide?a=10&b=5
    @GetMapping("/divide")
    public Long dividir(@RequestParam Long a, @RequestParam Long b) {
        return calculadoraService.dividir(a, b);
    }

    // 5. [BÔNUS] Handler de exceção para a divisão por zero.
    //    Retorna uma resposta HTTP 400 (Bad Request) amigável.
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}