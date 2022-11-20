package com.rlti.financas.despesas.application.service;

import com.rlti.financas.despesas.application.api.DespesaListResponse;
import com.rlti.financas.despesas.application.api.DespesaRequest;
import com.rlti.financas.despesas.application.api.DespesaResponse;
import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.parcelas.application.api.ParcelaRequest;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface DespesaService {
	DespesaResponse criaDespesa(DespesaRequest despesaRequest, ParcelaRequest parcelaRequest);
	List<DespesaListResponse> buscaTodasDespesas();
	void deletaDespesaAtravesId(UUID idDespesa);
	void patchAlteraDespesa(UUID idDespesa, @Valid DespesaRequest despesaRequest, ParcelaRequest parcelaRequest);
	List<DespesaListResponse> getDespesasPorData(LocalDate dataPagamento);
	List<DespesaListResponse> buscaTodasDespesasPeriodo(LocalDate dataInicial, LocalDate dataFinal);
	Despesa buscaDespesaAtravesId(UUID idDespesa);

}
