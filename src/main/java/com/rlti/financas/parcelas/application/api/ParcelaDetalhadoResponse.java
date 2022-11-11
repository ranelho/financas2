package com.rlti.financas.parcelas.application.api;

import com.rlti.financas.parcelas.domain.Parcela;
import com.rlti.financas.parcelas.domain.Situacao;
import lombok.Value;

import java.time.LocalDate;

@Value
public class ParcelaDetalhadoResponse {
    private String descricao;
    private String quantidadeParcelas;
    private Double valorParcela;
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
