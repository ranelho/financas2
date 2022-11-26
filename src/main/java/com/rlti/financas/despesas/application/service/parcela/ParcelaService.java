package com.rlti.financas.despesas.application.service.parcela;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.despesas.application.api.parcela.ParcelaIdResponse;
import com.rlti.financas.despesas.application.api.parcela.ParcelaListResponse;
import com.rlti.financas.despesas.application.api.parcela.ParcelaRequest;
import com.rlti.financas.despesas.domain.Parcela;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ParcelaService {
    ParcelaIdResponse criarParcela(Despesa despesa, ParcelaRequest parcelaRequest);
    List<ParcelaListResponse> getParcelasDespesa(Despesa despesa);
    List<ParcelaListResponse> getParcelas();
    Parcela getPacerla(UUID idParcela);
    void situacaoAPagar(Parcela parcela);
    void situacaoPago(Parcela parcela);
    List<ParcelaListResponse> buscaParcelasPeriodo(LocalDate dataInicial, LocalDate dataFinal);
    List<ParcelaListResponse> buscaParcelasAnual(int year);
    List<ParcelaListResponse> getCategoriaAnual(Categoria categoria, int year);
}
