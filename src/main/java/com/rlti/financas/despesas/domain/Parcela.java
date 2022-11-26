package com.rlti.financas.despesas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rlti.financas.despesas.application.api.parcela.ParcelaRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Parcela {
    @Id
    @Column(name = "id_Parcela", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID idParcela;
    @NotNull
    private String descricao;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @NotNull
    private String quantidadeParcelas;
    @NotNull
    private BigDecimal valorParcela;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataParcela;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Situacao situacao = Situacao.A_PAGAR ;
    @ManyToOne
    @JoinColumn(name = "despesa_id")
    @Type(type = "uuid-char")
    private Despesa despesa;

    public Parcela(Despesa despesa, ParcelaRequest parcelaRequest) {
        this.idParcela = UUID.randomUUID();
        this.categoria = parcelaRequest.getCategoria();
        this.descricao = parcelaRequest.getDescricao();
        this.quantidadeParcelas = parcelaRequest.getQuantidadeParcelas();
        this.valorParcela = parcelaRequest.getValorParcela();
        this.dataParcela = parcelaRequest.getDataParcela();
        this.situacao = Situacao.A_PAGAR;
        this.despesa = despesa;
    }

    public Parcela(ParcelaRequest parcelaRequest) {
        this.idParcela = UUID.randomUUID();
        this.categoria = parcelaRequest.getCategoria();
        this.descricao = parcelaRequest.getDescricao();
        this.quantidadeParcelas = parcelaRequest.getQuantidadeParcelas();
        this.valorParcela = parcelaRequest.getValorParcela();
        this.dataParcela = parcelaRequest.getDataParcela();
        this.situacao = Situacao.A_PAGAR;
        this.despesa = despesa;
    }

    public void pago() {
		this.situacao = Situacao.PAGO;
    }
    public void aPagar() {this.situacao = Situacao.A_PAGAR;	}
}
