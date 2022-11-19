package com.rlti.financas.despesas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rlti.financas.despesas.application.api.DespesaAlteracaoRequest;
import com.rlti.financas.despesas.application.api.DespesaRequest;
import com.rlti.financas.parcelas.domain.Parcela;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.Valid;
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
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idDespesa", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
	@Type(type = "uuid-char")
	private UUID idDespesa;
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
	private List<Parcela> parcelas;

	public Despesa(DespesaRequest despesaRequest) {
		this.idDespesa = UUID.randomUUID();
		this.categoria = despesaRequest.getCategoria();
		this.descricao = despesaRequest.getDescricao();
		this.dataPagamento = despesaRequest.getDataPagamento();
		this.quantidadeParcelas = despesaRequest.getQuantidadeParcelas();
		this.valorTotal = despesaRequest.getValorTotal();
		this.parcelas = despesaRequest.getParcelas();
	}
	public void altera(@Valid DespesaAlteracaoRequest despesaAlteracaoRequest) {
		this.descricao = despesaAlteracaoRequest.getDescricao();
		this.categoria = despesaAlteracaoRequest.getCategoria();
		this.quantidadeParcelas = despesaAlteracaoRequest.getQuantidadeParcelas();
		this.dataPagamento = despesaAlteracaoRequest.getDataPagamento();
		this.valorTotal = despesaAlteracaoRequest.getValorTotal();
	}
}
