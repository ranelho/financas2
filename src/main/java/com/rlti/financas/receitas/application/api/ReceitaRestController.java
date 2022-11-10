package com.rlti.financas.receitas.application.api;

import com.rlti.financas.receitas.application.service.ReceitaService;
import com.rlti.financas.receitas.domain.Receita;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ReceitaRestController implements ReceitaApi {
    private final ReceitaService receitaService;

    @Override
    public ReceitaIdResponse postNovaReceita(ReceitaRequest receitaRequest) {
        log.info("[inicia] ReceitaRestController - postNovaReceita");
        ReceitaIdResponse receitaCriada = receitaService.criaNovaReceita(receitaRequest);
        log.info("[finaliza] ReceitaRestController - postNovaReceita");
        return receitaCriada;
    }

    @Override
    public List<ReceitaListResponse> getTodasReceitas() {
        log.info("[inicia] ReceitaRestController - getTodasReceitas");
        List<ReceitaListResponse> receitas = receitaService.getReceitas();
        log.info("[finaliza] ReceitaRestController - getTodasReceitas");
        return receitas;
    }

    @Override
    public void deletaReceita(UUID idReceita) {
        log.info("[inicia] ReceitaRestController - deletaReceita");
        receitaService.deletaReceita(idReceita);
        log.info("[finaliza] ReceitaRestController - deletaReceita");
    }

    @Override
    public ReceitaDetalhadoResponse detalhaReceita(UUID idReceita) {
        log.info("[incicia] ReceitaRestController - detalhaReceita");
        Receita receita = receitaService.detalhaReceita(idReceita);
        log.info("[finaliza] ReceitaRestController - detalhaReceita");
        return new ReceitaDetalhadoResponse(receita);
    }
}
