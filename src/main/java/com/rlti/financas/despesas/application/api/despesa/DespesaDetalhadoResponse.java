package com.rlti.financas.despesas.application.api.despesa;

import com.rlti.financas.despesas.application.api.parcela.ParcelaListResponse;
import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.despesas.domain.Despesa;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static com.rlti.financas.despesas.application.api.parcela.ParcelaListResponse.converte;

@Value
public class DespesaDetalhadoResponse {
	private UUID idDespesa;
	private Categoria categoria;
	private int quantidadeParcelas;
	private BigDecimal valorTotal;
	private List<ParcelaListResponse> parcelas;
	
	public DespesaDetalhadoResponse(Despesa despesa) {
		this.idDespesa = despesa.getIdDespesa();
		this.categoria = despesa.getCategoria();
		this.quantidadeParcelas = despesa.getQuantidadeParcelas();
		this.valorTotal = despesa.getValorTotal();
		this.parcelas = converte(despesa.getParcelas());
	}
}
