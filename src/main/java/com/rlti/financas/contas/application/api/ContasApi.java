package com.rlti.financas.contas.application.api;

import com.rlti.financas.contas.domain.Contas;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v2/contas")
public interface ContasApi {
    @GetMapping(value = "/saldoPeriodo/{dataInicial},{dataFinal}")
    @ResponseStatus(code = HttpStatus.OK)
    ContasResponse getSaldoPeriodo(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicial,
                           @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal);

    @GetMapping(value = "/saldoAnual")
    @ResponseStatus(code = HttpStatus.OK)
    Contas getSaldoAnual(@RequestParam int year);

    @GetMapping(value = "/receitas-despesas-categoria")
    @ResponseStatus(code = HttpStatus.OK)
    List<ContasCategoriaResponse> getReceitasDespesasCategoria(@RequestParam int year);
}
