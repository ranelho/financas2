package com.rlti.financas.parcelas.application.service;

import com.rlti.financas.despesas.application.repository.DespesaRepository;
import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.handler.APIException;
import com.rlti.financas.parcelas.application.api.ParcelaIdResponse;
import com.rlti.financas.parcelas.application.api.ParcelaListResponse;
import com.rlti.financas.parcelas.application.api.ParcelaRequest;
import com.rlti.financas.parcelas.application.repository.ParcelaRepository;
import com.rlti.financas.parcelas.domain.Parcela;
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
public class ParcelaApplicationService implements ParcelaService {
    private final ParcelaRepository parcelaRepository;
    private final DespesaRepository despesaRepository;

    @Override
    public ParcelaIdResponse criarParcela(Despesa despesa, ParcelaRequest parcelaRequest) {
        log.info("[inicia] ParcelaApplicationService - criarParcela");
        Parcela parcela = parcelaRepository.salva(new Parcela(despesa, parcelaRequest));
        log.info("[finaliza] ParcelaApplicationService - criarParcela");
        return null;
    }

    @Override
    public List<ParcelaListResponse> getParcelasDespesaPorId(UUID idDespesa) {
        log.info("[inicia] ParcelaApplicationService - getparcelasDespesaPorId");
        List<Parcela> parcelas = parcelaRepository.buscaParcelasDespesa(idDespesa);
        log.info("[finalzia] ParcelaApplicationService - getparcelasDespesaPorId");
        return ParcelaListResponse.converte(parcelas);
    }

    @Override
    public List<ParcelaListResponse> getParcelas() {
        log.info("[inicia] ParcelaApplicationService - getParcelas");
        List<Parcela> parcelas = parcelaRepository.buscaParcelas();
        log.info("[finalzia] ParcelaApplicationService - getParcelas");
        return ParcelaListResponse.converte(parcelas);
    }
    @Override
    public Parcela getPacerla(UUID idParcela) {
        log.info("[inicia] ParcelaApplicationService - getPacerla");
        Parcela parcela = parcelaRepository.getParcela(idParcela)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Parcela não encontrada!"));
        log.info("[finalzia] ParcelaApplicationService - getPacerla");
        return parcela;
    }
     @Override
    public void situacaoAPagar(Parcela parcela) {
        log.info("[inicia] ParcelaApplicationService - situacaoPago");
        parcela.aPagar();
        parcelaRepository.salva(parcela);
        log.info("[finaliza] ParcelaApplicationService - situacaoPago");
    }

    @Override
    public void situacaoPago(Parcela parcela) {
        log.info("[inicia] ParcelaApplicationService - situacaoPago");
        parcela.pago();
        parcelaRepository.salva(parcela);
        log.info("[finalzia] ParcelaApplicationService - situacaoPago");
    }

    @Override
    public List<ParcelaListResponse> buscaParcelasPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        log.info("[inicia] ParcelaApplicationService - buscaParcelasPeriodo");
        List<Parcela> parcelas = parcelaRepository.buscaParcelasPeriodo(dataInicial, dataFinal);
        log.info("[finaliza] ParcelaApplicationService - buscaParcelasPeriodo");
        return ParcelaListResponse.converte(parcelas);
    }
}
