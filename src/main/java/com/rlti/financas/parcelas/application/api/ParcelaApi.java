package com.rlti.financas.parcelas.application.api;

import com.rlti.financas.despesas.domain.Despesa;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v2/parcelas")
public interface ParcelaApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ParcelaIdResponse postParcela(@Valid @RequestBody Despesa despesa, ParcelaRequest parcelaRequest);

    @GetMapping(value = "/parcelas-despesa")
    @ResponseStatus(code = HttpStatus.OK)
    List<ParcelaListResponse> getTodasParcelasDespesa(@RequestParam UUID idDespesa);

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
}
