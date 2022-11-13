package com.rlti.financas.contas.application.api;

import com.rlti.financas.contas.application.service.ContaService;
import com.rlti.financas.contas.domain.Contas;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ContasController implements ContasApi {
    private final ContaService contaService;
    @Override
    public Contas getSaldoPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        log.info("[inicia] ParcelaController - getSaldoPeriodo");
        Contas contas = contaService.listSaldo(dataInicial, dataFinal);
        log.info("[finaliza] ParcelaController - getSaldoPeriodo");
        return contas;
    }

    @Override
    public Contas getSaldoAnual(int year) {
        log.info("[inicia] ParcelaController - getSaldoAnual");
        Contas contas = contaService.listSaldoAnual(year);
        log.info("[inicia] ParcelaController - getSaldoAnual");
        return contas;
    }


}