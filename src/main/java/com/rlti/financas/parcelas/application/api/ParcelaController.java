package com.rlti.financas.parcelas.application.api;

import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.parcelas.application.service.ParcelaService;
import com.rlti.financas.parcelas.domain.Parcela;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ParcelaController implements ParcelaApi {
    private final ParcelaService parcelaService;

    @Override
    public ParcelaIdResponse postParcela(Despesa despesa, ParcelaRequest parcelaRequest) {
        log.info("[inicia] ParcelaController - postParcela");
        ParcelaIdResponse parcelaCriada = parcelaService.criarParcela(despesa, parcelaRequest);
        log.info("[finaliza] ParcelaController - postParcela");
        return parcelaCriada;
    }
    @Override
    public List<ParcelaListResponse> getTodasParcelasDespesa(UUID idDespesa) {
        log.info("[inicia] ParcelaController - getTodasParcelasDespesa");
        List<ParcelaListResponse> parcelas = parcelaService.getParcelasDespesaPorId(idDespesa);
        log.info("[finaliza] ParcelaController - getTodasParcelasDespesa");
        return parcelas;
    }
    @Override
    public List<ParcelaListResponse> getTodasParcelas() {
        log.info("[inicia] ParcelaController - getTodasParcelas");
        List<ParcelaListResponse> parcelas = parcelaService.getParcelas();
        log.info("[finaliza] ParcelaController - getTodasParcelas");
        return parcelas;
    }
    @Override
    public ParcelaDetalhadoResponse getParcelaAtravesId(UUID idParcela) {
        log.info("[inicia] ParcelaController - getParcelaAtravesId");
        Parcela parcela = parcelaService.getPacerla(idParcela);
        log.info("[finaliza] ParcelaController - getParcelaAtravesId");
        return new ParcelaDetalhadoResponse(parcela);
    }
    @Override
    public void situacaoPago(UUID idParcela) {
        log.info("[inicia] ParcelaController - situacaoPago");
        Parcela parcela = parcelaService.getPacerla(idParcela);
        parcelaService.situacaoPago(parcela);
        log.info("[finaliza] ParcelaController - situacaoPago");
    }
    @Override
    public void situacaoAPagar(UUID idParcela) {
        log.info("[inicia] ParcelaController - situacaoAPagar");
        Parcela parcela = parcelaService.getPacerla(idParcela);
        parcelaService.situacaoAPagar(parcela);
        log.info("[finaliza] ParcelaController - situacaoAPagar");
    }
    @Override
    public List<ParcelaListResponse> getDespesasPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        log.info("[inicia] ParcelaController - getDespesasPorPeriodo");
        List<ParcelaListResponse> parcelas = parcelaService.buscaParcelasPeriodo(dataInicial,dataFinal);
        log.info("[finaliza] ParcelaController - getDespesasPorPeriodo");
        return parcelas;
    }
}
