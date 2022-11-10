package com.rlti.financas.despesas.application.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.parcelas.domain.Parcela;

public interface DespesaRepository {
	Despesa salva(Despesa despesa);
	List<Despesa> buscaTodasDespesa();
	void deletaDespesa(UUID idDespesa);
	List<Despesa> buscaTodasDespesaPorData(LocalDate dataPagamento);
	List<Despesa> buscaTodasDespesaPeriodo(LocalDate dataInicial, LocalDate dataFinal);
	Optional<Despesa> buscaDespesaPorId(UUID idDespesa);
}
