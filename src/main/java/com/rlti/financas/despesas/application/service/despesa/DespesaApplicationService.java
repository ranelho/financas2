package com.rlti.financas.despesas.application.service.despesa;

import com.rlti.financas.despesas.application.api.despesa.DespesaListResponse;
import com.rlti.financas.despesas.application.api.despesa.DespesaRequest;
import com.rlti.financas.despesas.application.api.despesa.DespesaResponse;
import com.rlti.financas.despesas.application.api.parcela.ParcelaRequest;
import com.rlti.financas.despesas.application.repository.despesa.DespesaRepository;
import com.rlti.financas.despesas.application.repository.parcela.ParcelaRepository;
import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.despesas.domain.Parcela;
import com.rlti.financas.despesas.domain.ValidaMes;
import com.rlti.financas.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class DespesaApplicationService implements DespesaService {
	private final DespesaRepository despesaRepository;
	private final ParcelaRepository parcelaRepository;
	List<Parcela> parcelas = new ArrayList<>();
	String quantidadeParcelas;
	BigDecimal valorParcela;
	@Override
	public DespesaResponse criaDespesa(DespesaRequest despesaRequest, ParcelaRequest parcelaRequest) {
		log.info("[inicia] - DespesaApplicationService - criaDespesa");
		Despesa despesa = despesaRepository.salva(new Despesa(despesaRequest));
		valorParcela = despesaRequest.getValorTotal().divide(BigDecimal.valueOf(despesaRequest.getQuantidadeParcelas()));
		for (int count = 1; count <= despesaRequest.getQuantidadeParcelas(); count++) {
			quantidadeParcelas = count + "/" + despesaRequest.getQuantidadeParcelas();
			parcelaRequest.setCategoria(despesa.getCategoria());
			parcelaRequest.setValorParcela(valorParcela);
			parcelaRequest.setDataParcela(ValidaMes.validaMes(despesaRequest.getDataPagamento(), count));
			parcelaRequest.setDescricao(despesaRequest.getDescricao());
			parcelaRequest.setQuantidadeParcelas(quantidadeParcelas);
			parcelas.add(new Parcela(despesa, parcelaRequest));
		}
		parcelaRepository.salvaParcelas(parcelas);
		log.info("[finaliza] - DespesaApplicationService - criaDespesa");
		return DespesaResponse.builder().idDespesa(despesa.getIdDespesa()).build();
	}

	@Override
	public List<DespesaListResponse> buscaTodasDespesas() {
		log.info("[inicia] - DespesaApplicationService - buscaTodasDespesas");
		List<Despesa> despesas = despesaRepository.buscaTodasDespesa();
		log.info("[finaliza] - DespesaApplicationService - buscaTodasDespesas");
		if (despesas.isEmpty()) {
			throw APIException.build(HttpStatus.NOT_FOUND, "Nenhuma despesa econtrada!");
		} else {
			return DespesaListResponse.converte(despesas);
		}
	}

	@Override
	public void deletaDespesaAtravesId(UUID idDespesa) {
		log.info("[inicia] DespesaApplicationService - deletaDespesaAtravesId");
		buscaDespesaAtravesId(idDespesa);
		despesaRepository.deletaDespesa(idDespesa);
		log.info("[finaliza] DespesaApplicationService - deletaDespesaAtravesId");
	}

	@Override
	public void patchAlteraDespesa(UUID idDespesa, @Valid DespesaRequest despesaRequest, ParcelaRequest parcelaRequest) {
		log.info("[inicia] - DespesaApplicationService - patchAlteraDespesa");
		deletaDespesaAtravesId(idDespesa);
		despesaRequest.setIdDespesa(idDespesa);
		criaDespesa(despesaRequest,parcelaRequest);
		log.info("[finaliza] - DespesaApplicationService - patchAlteraDespesa");
	}

	@Override
	public List<DespesaListResponse> getDespesasPorData(LocalDate dataPagamento) {
		log.info("[inicia] - DespesaApplicationService - getDespesasPorData");
		List<Despesa> despesas = despesaRepository.buscaTodasDespesaPorData(dataPagamento);
		log.info("[finaliza] - DespesaApplicationService - getDespesasPorData");
		if (despesas.isEmpty()) {
			throw APIException.build(HttpStatus.NOT_FOUND, "Nenhuma despesa econtrada!");
		} else {
			return DespesaListResponse.converte(despesas);
		}
	}

	@Override
	public List<DespesaListResponse> buscaTodasDespesasPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
		log.info("[inicia] - DespesaApplicationService - buscaTodasDespesasPeriodo");
		List<Despesa> despesas = despesaRepository.buscaTodasDespesaPeriodo(dataInicial, dataFinal);
		log.info("[finaliza] - DespesaApplicationService - buscaTodasDespesasPeriodo");
		if (despesas.isEmpty()) {
			throw APIException.build(HttpStatus.NOT_FOUND, "Nenhuma despesa econtrada!");
		} else {
			return DespesaListResponse.converte(despesas);
		}		
	}

	@Override
	public Despesa buscaDespesaAtravesId(UUID idDespesa) {
		log.info("[inicia] - DespesaApplicationService - buscaDespesaAtravesId");
		Despesa despesa = despesaRepository.buscaDespesaPorId(idDespesa)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Despesa não encontrada!"));
		log.info("[finaliza] - DespesaApplicationService - buscaDespesaAtravesId");
		return despesa;
	}
}
