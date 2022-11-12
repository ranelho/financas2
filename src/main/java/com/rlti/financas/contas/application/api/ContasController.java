package com.rlti.financas.contas.application.api;

import com.rlti.financas.contas.domain.Contas;
import com.rlti.financas.contas.service.ContaService;
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
    public Contas getSaldoPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        log.info("[inicia] ParcelaController - getSaldoPeriodo");
        Contas contas = contaService.listSaldo(dataInicial, dataFinal);
        log.info("[finaliza] ParcelaController - getSaldoPeriodo");
        return contas;
    }
}
