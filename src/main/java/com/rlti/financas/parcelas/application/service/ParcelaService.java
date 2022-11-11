package com.rlti.financas.parcelas.application.service;

import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.parcelas.application.api.ParcelaIdResponse;
import com.rlti.financas.parcelas.application.api.ParcelaListResponse;
import com.rlti.financas.parcelas.application.api.ParcelaRequest;

import java.util.List;
import java.util.UUID;

public interface ParcelaService {
    ParcelaIdResponse criarParcela(Despesa despesa, ParcelaRequest parcelaRequest);
    List<ParcelaListResponse> getParcelasDespesaPorId(UUID idDespesa);
    List<ParcelaListResponse> getParcelas();
}
