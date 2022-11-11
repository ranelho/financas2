package com.rlti.financas.parcelas.infra;

import com.rlti.financas.parcelas.application.repository.ParcelaRepository;
import com.rlti.financas.parcelas.domain.Parcela;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
        return null;
    }

    @Override
    public List<Parcela> buscaParcelasDespesa(UUID idDespesa) {
        log.info("[inicia] ParcelaInfraRepository - buscaParcelasDespesa");
        List<Parcela> parcelas = parcelaSpringDataJPARepository.findAllByIdDespesa(idDespesa);
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
}
