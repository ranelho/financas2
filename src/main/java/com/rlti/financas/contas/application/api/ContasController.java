package com.rlti.financas.contas.application.api;

import com.rlti.financas.contas.application.service.ContaService;
import com.rlti.financas.contas.domain.Contas;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ContasController implements ContasApi {
    private final ContaService contaService;
    @Override
    public ContasResponse getSaldoPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        log.info("[inicia] ContasController - getSaldoPeriodo");
        Contas contas = contaService.listSaldo(dataInicial, dataFinal);
        log.info("[finaliza] ContasController - getSaldoPeriodo");
        return new ContasResponse(contas);
    }

    @Override
    public Contas getSaldoAnual(int year) {
        log.info("[inicia] ContasController - getSaldoAnual");
        Contas contas = contaService.listSaldoAnual(year);
        log.info("[inicia] ContasController - getSaldoAnual");
        return contas;
    }

    @Override
    public List<ContasCategoriaResponse> getReceitasDespesasCategoria(int year) {
        log.info("[inicia] ContasController - getReceitasDespesasCategoria");
        List<ContasCategoriaResponse> contas = contaService.getReceitasDespesasCategoria(year);
        log.info("[finaliza] ContasController - getReceitasDespesasCategoria");
        return contas;
    }
}