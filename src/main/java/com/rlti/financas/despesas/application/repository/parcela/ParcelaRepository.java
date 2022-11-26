package com.rlti.financas.despesas.application.repository.parcela;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.despesas.domain.Parcela;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParcelaRepository {
    Parcela salva(Parcela parcela);
    List<Parcela> buscaParcelasDespesa(Despesa despesa);
    List<Parcela> buscaParcelas();
    Optional<Parcela> getParcela(UUID idParcela);
    List<Parcela> buscaParcelasPeriodo(LocalDate dataInicial, LocalDate dataFinal);
    List<Parcela> buscaParcelasAnual(int year);
    List<Parcela> buscaCategoria(Categoria categoria, int year);
    void salvaParcelas(List<Parcela> parcelas);
}
