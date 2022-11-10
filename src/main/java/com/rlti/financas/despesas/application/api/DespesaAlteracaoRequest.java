package com.rlti.financas.despesas.application.api;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.parcelas.domain.Situacao;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
public class DespesaAlteracaoRequest {
	@NotNull
	private String descricao;
	@NotNull
	private Categoria categoria;
	private int parcelas;
	@NotNull
	private LocalDate dataPagamento;
	@NotNull
	private Double valor;
	@NotNull
	private Situacao situacao;
}
