package com.rlti.financas.parcelas.application.service;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.parcelas.application.api.ParcelaIdResponse;
import com.rlti.financas.parcelas.application.api.ParcelaListResponse;
import com.rlti.financas.parcelas.application.api.ParcelaRequest;
import com.rlti.financas.parcelas.domain.Parcela;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ParcelaService {
    ParcelaIdResponse criarParcela(Despesa despesa, ParcelaRequest parcelaRequest);
    List<ParcelaListResponse> getParcelasDespesaPorId(UUID idDespesa);
    List<ParcelaListResponse> getParcelas();
    Parcela getPacerla(UUID idParcela);
    void situacaoAPagar(Parcela parcela);
    void situacaoPago(Parcela parcela);
    List<ParcelaListResponse> buscaParcelasPeriodo(LocalDate dataInicial, LocalDate dataFinal);
    List<ParcelaListResponse> buscaParcelasAnual(int year);
    List<ParcelaListResponse> getCategoriaAnual(Categoria categoria, int year);
}
