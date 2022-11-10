package com.rlti.financas.receitas.application.api;

import com.rlti.financas.despesas.application.api.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v2/receita")
public interface ReceitaApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ReceitaIdResponse postNovaReceita(@RequestBody @Valid ReceitaRequest receitaRequest);

    @GetMapping("/get-receitas")
    @ResponseStatus(code = HttpStatus.OK)
    List<ReceitaListResponse> getTodasReceitas();

    @DeleteMapping("/deleta-receita/{idReceita}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaReceita (@PathVariable UUID idReceita);

    @GetMapping("detalha-receita/{idReceita}")
    @ResponseStatus(code = HttpStatus.OK)
    ReceitaDetalhadoResponse detalhaReceita(@PathVariable UUID idReceita);
}