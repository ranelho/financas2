package com.rlti.financas.receitas.application.service;

import com.rlti.financas.handler.APIException;
import com.rlti.financas.receitas.application.api.ReceitaAlteracaoRequest;
import com.rlti.financas.receitas.application.api.ReceitaIdResponse;
import com.rlti.financas.receitas.application.api.ReceitaListResponse;
import com.rlti.financas.receitas.application.api.ReceitaRequest;
import com.rlti.financas.receitas.application.repository.ReceitaRepository;
import com.rlti.financas.receitas.domain.Receita;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReceitaApplicationService implements ReceitaService {
    private final ReceitaRepository receitaRepository;

    @Override
    public ReceitaIdResponse criaNovaReceita(ReceitaRequest receitaRequest) {
        log.info("[inicia] ReceitaApplicationService - criaNovaReceita");
        Receita receitaCriada = receitaRepository.salva(new Receita(receitaRequest));
        log.info("[finaliza] ReceitaApplicationService - criaNovaReceita");
        return ReceitaIdResponse.builder().idReceita(receitaCriada.getIdReceita()).build();
    }
    @Override
    public List<ReceitaListResponse> getReceitas() {
        log.info("[inicia] ReceitaApplicationService - getReceitas");
        List<Receita> listaReceitas = receitaRepository.getReceitas();
        log.info("[finaliza] ReceitaApplicationService - getReceitas");
        return ReceitaListResponse.converte(listaReceitas);
    }

    @Override
    public void deletaReceita(UUID idReceita) {
        log.info("[inicia] ReceitaApplicationService - deletaReceita");
        detalhaReceita(idReceita);
        receitaRepository.deleta(idReceita);
        log.info("[inicia] ReceitaApplicationService - deletaReceita");
    }

    @Override
    public Receita detalhaReceita(UUID idReceita) {
        log.info("[inicial] ReceitaApplicationService - detalhaReceita");
        Receita receita = receitaRepository.buscaReceitaPorId(idReceita)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Receita não encontrada!"));
        log.info("[finaliza] ReceitaApplicationService - detalhaReceita");
        return receita;
    }

    @Override
    public List<ReceitaListResponse> receitasPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        log.info("[inicial] ReceitaApplicationService - receitasPeriodo");
        List<Receita> receitas = receitaRepository.receitasPeriodo(dataInicial, dataFinal);
        log.info("[finalisa] ReceitaApplicationService - receitasPeriodo");
        return ReceitaListResponse.converte(receitas);
    }

    @Override
    public List<ReceitaListResponse> getReceitasAnual(int year) {
        log.info("[inicial] ReceitaApplicationService - getReceitasAnual");
        List<Receita> receitas = receitaRepository.buscaReceitaAnual(year);
        log.info("[finaliza] ReceitaApplicationService - getReceitasAnual");
        return ReceitaListResponse.converte(receitas);
    }

    @Override
    public void alteraReceita(UUID idReceita, ReceitaAlteracaoRequest receitaAlteracaoRequest) {
        log.info("[inicial] ReceitaApplicationService - alteraReceita");
        Receita receita = receitaRepository.buscaReceitaPorId(idReceita)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Receita não encontrada!"));
        receita.altera(receitaAlteracaoRequest);
        receitaRepository.salva(receita);
        log.info("[finazaliza] ReceitaApplicationService - alteraReceita");
    }
}
