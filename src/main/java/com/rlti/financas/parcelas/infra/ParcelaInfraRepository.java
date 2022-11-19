package com.rlti.financas.parcelas.infra;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.parcelas.application.repository.ParcelaRepository;
import com.rlti.financas.parcelas.domain.Parcela;
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
public class ParcelaInfraRepository implements ParcelaRepository {
    private final ParcelaSpringDataJPARepository parcelaSpringDataJPARepository;

    @Override
    public Parcela salva(Parcela parcela) {
        log.info("[inicia] ParcelaInfraRepository - salva");
        parcelaSpringDataJPARepository.save(parcela);
        log.info("[finaliza] ParcelaInfraRepository - salva");
        return parcela;
    }

    @Override
    public List<Parcela> buscaParcelasDespesa(Despesa despesa) {
        log.info("[inicia] ParcelaInfraRepository - buscaParcelasDespesa");
        List<Parcela> parcelas = parcelaSpringDataJPARepository.findAllByDespesa(despesa);
        log.info("[finaliza] ParcelaInfraRepository - buscaParcelasDespesa");
        return parcelas;
    }

    @Override
    public List<Parcela> buscaParcelas() {
        log.info("[inicia] ParcelaInfraRepository - buscaParcelasDespesa");
        List<Parcela> parcelas = parcelaSpringDataJPARepository.findAll();
        log.info("[finaliza] ParcelaInfraRepository - buscaParcelasDespesa");
        return parcelas;
    }

    @Override
    public Optional<Parcela> getParcela(UUID idParcela) {
        log.info("[inicia] ParcelaInfraRepository - getParcela");
        Optional<Parcela> parcela = parcelaSpringDataJPARepository.findById(idParcela);
        log.info("[finaliza] ParcelaInfraRepository - getParcela");
        return parcela;
    }

    @Override
    public List<Parcela> buscaParcelasPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        log.info("[inicia] ParcelaInfraRepository - buscaParcelasPeriodo");
        List<Parcela> parcelas = parcelaSpringDataJPARepository.findPeriodo(dataInicial, dataFinal);
        log.info("[finaliza] ParcelaInfraRepository - buscaParcelasPeriodo");
        return parcelas;
    }

    @Override
    public List<Parcela> buscaParcelasAnual(int year) {
        log.info("[inicia] ParcelaInfraRepository - buscaParcelasAno");
        List<Parcela> parcelas = parcelaSpringDataJPARepository.findAllYear(year);
        log.info("[inicia] ParcelaInfraRepository - buscaParcelasAno");
        return parcelas;
    }

    @Override
    public List<Parcela> buscaCategoria(Categoria categoria, int year) {
        log.info("[inicia] ParcelaInfraRepository - buscaSomaCategoria");
        String categoriaString = String.valueOf(Categoria.valueOf (String.valueOf(categoria)));
        List<Parcela> parcela = parcelaSpringDataJPARepository.findAllCategoria(categoriaString, year);
        log.info("[finaliza] ParcelaInfraRepository - buscaSomaCategoria");
        return parcela;
    }
}
