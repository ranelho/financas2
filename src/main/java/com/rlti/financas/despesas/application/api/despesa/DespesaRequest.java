package com.rlti.financas.despesas.application.api.despesa;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.despesas.domain.Parcela;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DespesaRequest {
	private UUID idDespesa;
	private Categoria categoria;
	@Size(message = "Campo descrição não pode estar vazio", min = 3, max = 255)
	private String descricao;
	@NotNull
	private LocalDate dataPagamento;
	@NotNull
	private int quantidadeParcelas;
	@NotNull
	@DecimalMin(value = "0.1", message = "Valor abaixo de: ${value}")
	private BigDecimal valorTotal;
	private List<Parcela> parcelas;
}

