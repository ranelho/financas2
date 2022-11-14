package com.rlti.financas.contas.application.service;

import com.rlti.financas.contas.application.api.ContasCategoriaResponse;
import com.rlti.financas.contas.domain.Contas;
import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.parcelas.application.repository.ParcelaRepository;
import com.rlti.financas.parcelas.domain.Parcela;
import com.rlti.financas.receitas.application.repository.ReceitaRepository;
import com.rlti.financas.receitas.domain.Receita;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ContaApplicationService implements ContaService {
    private final ParcelaRepository parcelaRepository;
    private final ReceitaRepository receitaRepository;
    Contas contas;
    @Override
    public Contas listSaldo(LocalDate dataInicial, LocalDate dataFinal) {
        log.info("[inicia] ContaApplicationService - listSaldo");
        List<Parcela> parcelas = parcelaRepository.buscaParcelasPeriodo(dataInicial, dataFinal);
        List<Receita> receitas = receitaRepository.receitasPeriodo(dataInicial, dataFinal);
        Contas contas = new Contas(parcelas, receitas);
        log.info("[finaliza] ContaApplicationService - listSaldo");
        return contas;
    }

    @Override
    public Contas listSaldoAnual(int year) {
        log.info("[inicia] ContaApplicationService - listSaldoAnual");
        List<Receita> receitas = receitaRepository.buscaReceitaAnual(year);
        List<Parcela> parcelas = parcelaRepository.buscaParcelasAno(year);
        Contas contas = new Contas(parcelas,receitas);
        log.info("[finaliza] ContaApplicationService - listSaldoAnual");
        return contas;
    }

    @Override
    public List<ContasCategoriaResponse> getReceitasDespesasCategoria(int year) {
        log.info("[inicia] ContaApplicationService - getReceitasDespesasCategoria");
        List<Contas> contas = new ArrayList<>();
        for (Categoria categoria : Categoria.values()) {
           // String categoriaString = String.valueOf(Categoria.valueOf (String.valueOf(categoria)));
            List<Parcela> parcelas = parcelaRepository.buscaCategoria(categoria, year);
            if(parcelas.isEmpty()){}
            else {
                contas.add(new Contas(categoria, parcelas));
            }
        }
        log.info("[finaliza] ContaApplicationService - getReceitasDespesasCategoria");
        return ContasCategoriaResponse.converte(contas);
    }
}
