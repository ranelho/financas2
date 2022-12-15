package com.rlti.financas.despesas.infra.parcela;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.despesas.domain.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ParcelaSpringDataJPARepository extends JpaRepository<Parcela, UUID> {

    //@Query(value = "SELECT * FROM parcela WHERE data_parcela >= ?1 and data_parcela <= ?2 ", nativeQuery = true)
    @Query("select p from Parcela p where p.dataParcela >= ?1 and p.dataParcela <= ?2")
    List<Parcela> findPeriodo(LocalDate dataInicial, LocalDate dataFinal);

   /* @Query(value = "SELECT * FROM parcela WHERE YEAR(data_parcela) = ?1 ", nativeQuery = true)*/
    @Query(value = "SELECT p FROM Parcela p WHERE YEAR(p.dataParcela) = ?1 ")
    List<Parcela> findAllYear(int year);

    @Query(value = "SELECT p FROM Parcela p WHERE p.despesa = ?1 ")
    List<Parcela> findAllByDespesa(Despesa despesa);

    @Query(value = "SELECT p FROM Parcela p WHERE p.categoria = ?1 AND year(p.dataParcela) = ?2")
    List<Parcela> findAllCategoria(Categoria categoria, int year);
}
