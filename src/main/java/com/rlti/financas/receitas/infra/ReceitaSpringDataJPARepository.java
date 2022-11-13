package com.rlti.financas.receitas.infra;

import com.rlti.financas.receitas.domain.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ReceitaSpringDataJPARepository extends JpaRepository<Receita, UUID> {
    @Query(value = "SELECT * FROM receita WHERE data_receita >= ?1 and data_receita <= ?2 ", nativeQuery = true)
    List<Receita> findReceitasPeriodo(LocalDate dataInicial, LocalDate dataFinal);
    @Query(value = "SELECT * FROM receita WHERE YEAR(data_receita) = ?1 ", nativeQuery = true)
    List<Receita> findAllReceitaYear(int year);
}
