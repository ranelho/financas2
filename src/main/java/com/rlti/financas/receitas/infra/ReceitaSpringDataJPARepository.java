package com.rlti.financas.receitas.infra;

import com.rlti.financas.receitas.domain.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ReceitaSpringDataJPARepository extends JpaRepository<Receita, UUID> {
    @Query(value = "SELECT r FROM Receita r WHERE r.dataReceita >= ?1 AND r.dataReceita <= ?2 ")
    List<Receita> findReceitasPeriodo(LocalDate dataInicial, LocalDate dataFinal);
    @Query(value = "SELECT r FROM Receita r WHERE YEAR(r.dataReceita) = ?1 ")
    List<Receita> findAllReceitaYear(int year);
}
