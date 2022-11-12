package com.rlti.financas.contas.application.api;

import com.rlti.financas.contas.domain.Contas;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v2/contas")
public interface ContasApi {
    @GetMapping(value = "/saldo/{dataInicial},{dataFinal}")
    @ResponseStatus(code = HttpStatus.OK)
    Contas getSaldoPeriodo(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicial,
                           @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal);


}