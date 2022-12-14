package com.rlti.financas.despesas.application.api.parcela;

import com.rlti.financas.despesas.domain.Parcela;
import com.rlti.financas.despesas.domain.Situacao;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class ParcelaDetalhadoResponse {
    private String descricao;
    private String quantidadeParcelas;
    private BigDecimal valorParcela;
    private LocalDate dataParcela;
    private Situacao situacao ;

    public ParcelaDetalhadoResponse(Parcela parcela) {
        this.descricao = parcela.getDescricao();
        this.quantidadeParcelas = parcela.getQuantidadeParcelas();
        this.valorParcela = parcela.getValorParcela();
        this.dataParcela = parcela.getDataParcela();
        this.situacao = parcela.getSituacao();
    }
}
