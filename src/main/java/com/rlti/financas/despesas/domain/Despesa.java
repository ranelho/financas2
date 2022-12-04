package com.rlti.financas.despesas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rlti.financas.despesas.application.api.despesa.DespesaRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Despesa {
	@Id
	@Column(name = "idDespesa", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
	@Type(type = "uuid-char")
	private UUID idDespesa = null;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	@NotNull
	private String descricao;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataPagamento;
	@NotNull
	private int quantidadeParcelas;
	@NotNull
	private BigDecimal valorTotal;
	@OneToMany(mappedBy="despesa", cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	private List<Parcela> parcelas;

	public Despesa(DespesaRequest despesaRequest) {
		if (despesaRequest.getIdDespesa() == null) {
			this.idDespesa = UUID.randomUUID();
		}else {
			this.idDespesa = despesaRequest.getIdDespesa();
		}
		this.categoria = despesaRequest.getCategoria();
		this.descricao = despesaRequest.getDescricao();
		this.dataPagamento = despesaRequest.getDataPagamento();
		this.quantidadeParcelas = despesaRequest.getQuantidadeParcelas();
		this.valorTotal = despesaRequest.getValorTotal();
		this.parcelas = despesaRequest.getParcelas();
	}
}
