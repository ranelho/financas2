package com.rlti.financas.contas.application.service;

import com.rlti.financas.contas.domain.Contas;
import com.rlti.financas.parcelas.application.repository.ParcelaRepository;
import com.rlti.financas.parcelas.domain.Parcela;
import com.rlti.financas.receitas.application.repository.ReceitaRepository;
import com.rlti.financas.receitas.domain.Receita;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ContaApplicationService implements ContaService {
    private final ParcelaRepository parcelaRepository;
    private final ReceitaRepository receitaRepository;
    @Override
    public Contas listSaldo(LocalDate dataInicial, LocalDate dataFinal) {
        log.info("[inicia] ParcelaApplicationService - listSaldo");
        List<Parcela> parcelas = parcelaRepository.buscaParcelasPeriodo(dataInicial, dataFinal);
        List<Receita> receitas = receitaRepository.receitasPeriodo(dataInicial, dataFinal);
        Contas contas = new Contas(parcelas, receitas);
        log.info("[finaliza] ParcelaApplicationService - listSaldo");
        return contas;
    }

    @Override
    public Contas listSaldoAnual(int year) {
        log.info("[inicia] ParcelaApplicationService - listSaldoAnual");
        List<Receita> receitas = receitaRepository.buscaReceitaAnual(year);
        List<Parcela> parcelas = parcelaRepository.buscaParcelasAno(year);
        Contas contas = new Contas(parcelas,receitas);
        log.info("[finaliza] ParcelaApplicationService - listSaldoAnual");
        return contas;
    }
}
