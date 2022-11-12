package com.rlti.financas.parcelas.application.repository;

import com.rlti.financas.parcelas.domain.Parcela;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParcelaRepository {
    Parcela salva(Parcela parcela);
    List<Parcela> buscaParcelasDespesa(UUID idDespesa);
    List<Parcela> buscaParcelas();
    Optional<Parcela> getParcela(UUID idParcela);
    List<Parcela> buscaParcelasPeriodo(LocalDate dataInicial, LocalDate dataFinal);
}
