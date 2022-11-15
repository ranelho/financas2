package com.rlti.financas.parcelas.infra;

import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.parcelas.domain.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ParcelaSpringDataJPARepository extends JpaRepository<Parcela, UUID> {

    @Query(value = "SELECT * FROM parcela WHERE data_parcela >= ?1 and data_parcela <= ?2 ", nativeQuery = true)
    List<Parcela> findPeriodo(LocalDate dataInicial, LocalDate dataFinal);

    @Query(value = "SELECT * FROM parcela WHERE YEAR(data_parcela) = ?1 ", nativeQuery = true)
    List<Parcela> findAllYear(int year);

    @Query(value = "SELECT * FROM parcela WHERE categoria = ?1 AND year(data_parcela) = ?2", nativeQuery = true)
    List<Parcela> findAllCategoria(String categoria, int year);

    @Query(value = "SELECT * FROM parcela WHERE despesa_id = ?1 ", nativeQuery = true)
    List<Parcela> findAllByDespesa(Despesa despesa);
}
