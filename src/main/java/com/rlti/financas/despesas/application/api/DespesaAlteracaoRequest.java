package com.rlti.financas.despesas.application.api;

import com.rlti.financas.despesas.domain.Categoria;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class DespesaAlteracaoRequest {
	@NotNull
	private String descricao;
	@NotNull
	private Categoria categoria;
	@NotNull
	private int quantidadeParcelas;
	@NotNull
	private LocalDate dataPagamento;
	@NotNull
	private BigDecimal valorTotal;
}
