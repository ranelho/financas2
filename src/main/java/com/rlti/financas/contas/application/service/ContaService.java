package com.rlti.financas.contas.application.service;

import com.rlti.financas.contas.application.api.ContasCategoriaResponse;
import com.rlti.financas.contas.domain.Contas;

import java.time.LocalDate;
import java.util.List;

public interface ContaService {
    Contas listSaldo(LocalDate dataInicial, LocalDate dataFinal);
    Contas listSaldoAnual(int year);
    List<ContasCategoriaResponse> getReceitasDespesasCategoria(int year);
}
