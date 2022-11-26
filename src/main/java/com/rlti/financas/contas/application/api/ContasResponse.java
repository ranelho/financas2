package com.rlti.financas.contas.application.api;

import com.rlti.financas.contas.domain.Contas;
import com.rlti.financas.despesas.application.api.parcela.ParcelaListResponse;
import com.rlti.financas.receitas.application.api.ReceitaListResponse;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ContasResponse {
    private BigDecimal valorTotalReceitas;
    private BigDecimal valorTotalParcelas;
    private BigDecimal saldoGeral;
    private List<ParcelaListResponse> parcelas;
    private List<ReceitaListResponse> receitas;
    public ContasResponse(Contas contas){
        this.valorTotalReceitas = contas.getValorTotalReceitas();
        this.valorTotalParcelas = contas.getValorTotalParcelas();
        this.saldoGeral = contas.getSaldoGeral();
        this.parcelas = contas.getParcelas();
        this.receitas = contas.getReceitas();
    }

    public static List<ContasResponse> converte(List<Contas> contas) {
        return contas.stream()
                .map(ContasResponse::new)
                .collect(Collectors.toList());
    }
}