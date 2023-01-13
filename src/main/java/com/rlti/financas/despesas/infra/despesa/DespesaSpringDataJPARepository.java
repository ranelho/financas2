package com.rlti.financas.despesas.infra.despesa;

import com.rlti.financas.despesas.domain.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface DespesaSpringDataJPARepository extends JpaRepository<Despesa, UUID>{
	@Query(value = "SELECT d FROM Despesa d WHERE d.dataPagamento = ?1 ")
	List<Despesa> findAllPorDataPagamento(LocalDate dataPagamento);

	@Query(value = "SELECT d FROM Despesa d WHERE d.dataPagamento >= ?1 AND d.dataPagamento <= ?2")
	List<Despesa> findALLPeriodo(LocalDate dataInicial, LocalDate dataFinal);
}

