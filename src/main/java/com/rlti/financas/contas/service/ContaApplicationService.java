package com.rlti.financas.contas.service;

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
    //Contas contas = new Contas();
    @Override
    public Contas listSaldo(LocalDate dataInicial, LocalDate dataFinal) {
        log.info("[inicia] ParcelaApplicationService - listSaldo");
        List<Parcela> parcelas = parcelaRepository.buscaParcelasPeriodo(dataInicial, dataFinal);
        List<Receita> receitas = receitaRepository.receitasPeriodo(dataInicial, dataFinal);
        Contas contas = new Contas(parcelas, receitas);
        log.info("[finaliza] ParcelaApplicationService - listSaldo");
        return contas;
    }
}
