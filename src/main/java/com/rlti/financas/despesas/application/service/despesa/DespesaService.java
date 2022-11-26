package com.rlti.financas.despesas.application.service.despesa;

import com.rlti.financas.despesas.application.api.despesa.DespesaListResponse;
import com.rlti.financas.despesas.application.api.despesa.DespesaRequest;
import com.rlti.financas.despesas.application.api.despesa.DespesaResponse;
import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.despesas.application.api.parcela.ParcelaRequest;

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
