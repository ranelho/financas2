package com.rlti.financas.despesas.infra;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rlti.financas.despesas.domain.Despesa;

public interface DespesaSpringDataJPARepository extends JpaRepository<Despesa, UUID>{
	@Query(value = "SELECT * FROM despesa WHERE data_pagamento = ?1 ", nativeQuery = true)	
	List<Despesa> findAllPorDataPagamento(LocalDate dataPagamento);

	@Query(value = "SELECT * FROM despesa WHERE data_pagamento >= ?1 AND data_pagamento <= ?2", nativeQuery = true)	
	List<Despesa> findALLPeriodo(LocalDate dataInicial, LocalDate dataFinal);

}

