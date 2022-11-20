package com.rlti.financas.despesas.application.api;

import com.rlti.financas.despesas.application.service.DespesaService;
import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.parcelas.application.api.ParcelaRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class DespesaController implements DespesaApi {
	private final DespesaService despesaService;

	@Override
	public DespesaResponse postDespesa(@Valid DespesaRequest despesaRequest, ParcelaRequest parcelaRequest) {
		log.info("[inicia] DespesaController - postDespesa");
		DespesaResponse despesaCriada = despesaService.criaDespesa(despesaRequest, parcelaRequest);
		log.info("[finaliza] DespesaController - postDespesa");		
		return despesaCriada;
	}

	@Override
	public List<DespesaListResponse> getTodasDespesas() {
		log.info("[inicia] DespesaController - getTodasDespesas");
		List<DespesaListResponse> despesas = despesaService.buscaTodasDespesas();
		log.info("[finaliza] DespesaController - getTodasDespesas");
		return despesas;
	}

	@Override
	public DespesaDetalhadoResponse getDespesaAtravesId(UUID idDespesa) {
		log.info("[inicia] DespesaController - getDespesaAtravesId");
		Despesa despesa = despesaService.buscaDespesaAtravesId(idDespesa);
		log.info("[finaliza] DespesaController - getDespesaAtravesId");
		return new DespesaDetalhadoResponse(despesa);
	}

	@Override
	public void deletaDespesaAtravesId(UUID idDespesa) {
		log.info("[inicia] DespesaController - deletaDespesaAtravesId");
		despesaService.deletaDespesaAtravesId(idDespesa);
		log.info("[finaliza] DespesaController - deletaDespesaAtravesId");
	}

	@Override
	public void patchAlteraDespesa(UUID idDespesa, @Valid DespesaRequest despesaRequest, ParcelaRequest parcelaRequest) {
		log.info("[inicia] DespesaController - patchAlteraDespesa");
		despesaService.patchAlteraDespesa(idDespesa, despesaRequest, parcelaRequest);
		log.info("[finaliza] DespesaController - patchAlteraDespesa");
	}
	@Override
	public List<DespesaListResponse> getDespesasPorData(LocalDate dataPagamento) {		
		log.info("[inicia] DespesaController - getDespesaPorData");
		List<DespesaListResponse> despesas = despesaService.getDespesasPorData(dataPagamento);
		log.info("[finaliza] DespesaController - getDespesaPorData");
		return despesas;
	}

	@Override
	public List<DespesaListResponse> getDespesasPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
		log.info("[inicia] DespesaController - getDespesasPorPeriodo");
		List<DespesaListResponse> despesas = despesaService.buscaTodasDespesasPeriodo(dataInicial, dataFinal);
		log.info("[final] DespesaController - getDespesasPorPeriodo");
		return despesas;
	}
}
