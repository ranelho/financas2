package com.rlti.financas.parcelas.application.service;

import com.rlti.financas.despesas.application.repository.DespesaRepository;
import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.parcelas.application.api.ParcelaIdResponse;
import com.rlti.financas.parcelas.application.api.ParcelaListResponse;
import com.rlti.financas.parcelas.application.api.ParcelaRequest;
import com.rlti.financas.parcelas.application.repository.ParcelaRepository;
import com.rlti.financas.parcelas.domain.Parcela;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ParcelaApplicationService implements ParcelaService {
    private final ParcelaRepository parcelaRepository;
    private final DespesaRepository despesaRepository;

    @Override
    public ParcelaIdResponse criarParcela(Despesa despesa, ParcelaRequest parcelaRequest) {
        log.info("[inicia] ParcelaApplicationService - criarParcela");
        //Optional<Despesa> despesas = despesaRepository.buscaDespesaPorId(parcelaRequest.getDespesa().getIdDespesa());
        //Despesa despesa = despesas.get();
        Parcela parcela = parcelaRepository.salva(new Parcela(despesa, parcelaRequest));
        log.info("[finaliza] ParcelaApplicationService - criarParcela");
        return null;
    }

    @Override
    public List<ParcelaListResponse> getParcelasDespesaPorId(UUID idDespesa) {
        log.info("[inicia] ParcelaApplicationService - getparcelasDespesaPorId");
        List<ParcelaListResponse> parcelas = parcelaRepository.buscaParcelasDespesa(idDespesa);
        log.info("[finalzia] ParcelaApplicationService - getparcelasDespesaPorId");
        return null;
    }
}
