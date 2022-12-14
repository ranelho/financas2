package com.rlti.financas.receitas.infra;

import com.rlti.financas.receitas.application.repository.ReceitaRepository;
import com.rlti.financas.receitas.domain.Receita;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ReceitaInfraRepository implements ReceitaRepository {
    private final ReceitaSpringDataJPARepository receitaSpringDataJPARepository;

    @Override
    public Receita salva(Receita receita) {
       log.info("[inicia] ReceitaInfraRepository - salva");
       receitaSpringDataJPARepository.save(receita);
       log.info("[finaliza] ReceitaInfraRepository - salva");
       return receita;
    }

    @Override
    public List<Receita> getReceitas() {
        log.info("[inicia] ReceitaInfraRepository - getReceitas");
        List<Receita> receitas = receitaSpringDataJPARepository.findAll();
        log.info("[finaliza] ReceitaInfraRepository - getReceitas");
        return receitas;
    }

    @Override
    public void deleta(UUID idReceita) {
        log.info("[inicia] - ReceitaInfraRepository - deleta");
        receitaSpringDataJPARepository.deleteById(idReceita);
        log.info("[finaliza] - ReceitaInfraRepository - deleta");
    }

    @Override
    public Optional<Receita> buscaReceitaPorId(UUID idReceita) {
        log.info("[inicia] - ReceitaInfraRepository - buscaReceitaPorId");
        Optional<Receita> receitaPorId = receitaSpringDataJPARepository.findById(idReceita);
        log.info("[finaliza] - ReceitaInfraRepository - buscaReceitaPorId");
        return receitaPorId;
    }

    @Override
    public List<Receita> receitasPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        log.info("[inicia] - ReceitaInfraRepository - receitasPeriodo");
        List<Receita> receitas = receitaSpringDataJPARepository.findReceitasPeriodo(dataInicial, dataFinal);
        log.info("[finaliza] - ReceitaInfraRepository - receitasPeriodo");
        return receitas;
    }

    @Override
    public List<Receita> buscaReceitaAnual(int year) {
        log.info("[inicia] - ReceitaInfraRepository - buscaReceitaAnual");
        List<Receita> receitas = receitaSpringDataJPARepository.findAllReceitaYear(year);
        log.info("[finaliza] - ReceitaInfraRepository - buscaReceitaAnual");
        return receitas;
    }
}
