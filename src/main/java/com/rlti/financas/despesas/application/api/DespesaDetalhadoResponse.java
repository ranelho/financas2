package com.rlti.financas.despesas.application.api;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.despesas.domain.Despesa;
import lombok.Value;

import java.util.UUID;

@Value
public class DespesaDetalhadoResponse {
	private UUID idDespesa;
	private Categoria categoria;
	private int quantidadeParcelas;
	private Double valorTotal;
	
	public DespesaDetalhadoResponse(Despesa despesa) {
		this.idDespesa = despesa.getIdDespesa();
		this.categoria = despesa.getCategoria();
		this.quantidadeParcelas = despesa.getQuantidadeParcelas();
		this.valorTotal = despesa.getValorTotal();
	}
}
