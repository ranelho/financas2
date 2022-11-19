package com.rlti.financas.despesas.application.api;

import com.rlti.financas.parcelas.application.api.ParcelaRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v2/despesa")
public interface DespesaApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    DespesaResponse postDespesa(@Valid @RequestBody DespesaRequest despesaRequest, ParcelaRequest parcelaRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<DespesaListResponse> getTodasDespesas();

    @GetMapping(value = "/{idDespesa}")
    @ResponseStatus(code = HttpStatus.OK)
    DespesaDetalhadoResponse getDespesaAtravesId(@PathVariable UUID idDespesa);

    @GetMapping(value = "/dataPagamento/{dataPagamento}")
    @ResponseStatus(code = HttpStatus.OK)
    List<DespesaListResponse> getDespesasPorData(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataPagamento);

    @GetMapping(value = "/periodo/{dataInicial},{dataFinal}")
    @ResponseStatus(code = HttpStatus.OK)
    List<DespesaListResponse> getDespesasPorPeriodo(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicial,
                                                    @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal);

    @DeleteMapping(value = "/deleteDespesa")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaDespesaAtravesId(@RequestParam UUID idDespesa);

    @PatchMapping(value = "/update/{idDespesa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchAlteraDespesa(@PathVariable UUID idDespesa, @Valid @RequestBody DespesaAlteracaoRequest despesaAlteracaoRequest);
}