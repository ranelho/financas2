package com.rlti.financas.despesas.application.api.despesa;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.despesas.domain.Despesa;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class DespesaDetalhadoResponse {
	private UUID idDespesa;
	private Categoria categoria;
	private int quantidadeParcelas;
	private BigDecimal valorTotal;
	
	public DespesaDetalhadoResponse(Despesa despesa) {
		this.idDespesa = despesa.getIdDespesa();
		this.categoria = despesa.getCategoria();
		this.quantidadeParcelas = despesa.getQuantidadeParcelas();
		this.valorTotal = despesa.getValorTotal();
	}
}
