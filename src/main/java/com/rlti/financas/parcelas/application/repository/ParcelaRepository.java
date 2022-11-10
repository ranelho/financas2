package com.rlti.financas.parcelas.application.repository;

import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.parcelas.application.api.ParcelaListResponse;
import com.rlti.financas.parcelas.domain.Parcela;

import java.util.List;
import java.util.UUID;

public interface ParcelaRepository {
    Parcela salva(Parcela parcela);
    List<ParcelaListResponse> buscaParcelasDespesa(UUID idDespesa);
}
