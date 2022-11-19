package com.rlti.financas.despesas.application.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.handler.APIException;
import lombok.Value;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class DespesaListResponse {
	private UUID idDespesa;
	private Categoria categoria;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataPagamento;
	private int parcelas;
	private BigDecimal valorTotal;
	public static List<DespesaListResponse> converte(List<Despesa> despesas) {
		if (despesas.isEmpty()) {
			throw APIException.build(HttpStatus.NOT_FOUND, "Nenhuma tarefa econtrada!");
		} else {
			return despesas.stream()
					.map(DespesaListResponse::new)
					.collect(Collectors.toList());
		}
	}
	private DespesaListResponse(Despesa despesa) {
		this.idDespesa = despesa.getIdDespesa();
		this.categoria = despesa.getCategoria();
		this.dataPagamento = despesa.getDataPagamento();
		this.parcelas = despesa.getQuantidadeParcelas();
		this.valorTotal = despesa.getValorTotal();
	}

	public DespesaListResponse(LocalDate dataPagamento, int parcela, double valor) {
		this.idDespesa = null;
		this.categoria = null;
		this.dataPagamento = dataPagamento;
		this.parcelas = parcela;
		this.valorTotal = BigDecimal.valueOf(valor);
	}
}
