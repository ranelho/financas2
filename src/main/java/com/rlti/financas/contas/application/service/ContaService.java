package com.rlti.financas.contas.application.service;

import com.rlti.financas.contas.domain.Contas;

import java.time.LocalDate;

public interface ContaService {
    Contas listSaldo(LocalDate dataInicial, LocalDate dataFinal);
    Contas listSaldoAnual(int year);
}
