package com.rlti.financas.despesas.application.api.parcela;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.despesas.domain.Despesa;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v2/despesa/parcelas")
public interface ParcelaApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ParcelaIdResponse postParcela(@Valid @RequestBody Despesa despesa, ParcelaRequest parcelaRequest);

    @GetMapping(value = "/parcelas-despesa")
    @ResponseStatus(code = HttpStatus.OK)
    List<ParcelaListResponse> getTodasParcelasDespesa(@RequestParam Despesa despesa);

    @GetMapping(value = "/allParcelas")
    @ResponseStatus(code = HttpStatus.OK)
    List<ParcelaListResponse> getTodasParcelas();

    @GetMapping(value = "/{idParcela}")
    @ResponseStatus(code = HttpStatus.OK)
    ParcelaDetalhadoResponse getParcelaAtravesId(@PathVariable UUID idParcela);

    @PostMapping(value = "/pago")
    @ResponseStatus(code = HttpStatus.CREATED)
    void situacaoPago(@RequestParam UUID idParcela);

    @PostMapping(value = "/aPagar")
    @ResponseStatus(code = HttpStatus.CREATED)
    void situacaoAPagar(@RequestParam UUID idParcela);

    @GetMapping(value = "/periodo/{dataInicial},{dataFinal}")
    @ResponseStatus(code = HttpStatus.OK)
    List<ParcelaListResponse> getDespesasPorPeriodo(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicial,
                                                    @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal);

    @GetMapping(value = "/year")
    @ResponseStatus(code = HttpStatus.OK)
    List<ParcelaListResponse> getParcelasAnual(@RequestParam int year);

    @GetMapping(value = "/categoria/year")
    @ResponseStatus(code = HttpStatus.OK)
    List<ParcelaListResponse> getCategoriaAnual(@RequestParam Categoria categoria, @RequestParam int year);
}
