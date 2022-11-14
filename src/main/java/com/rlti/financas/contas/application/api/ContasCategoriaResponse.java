package com.rlti.financas.contas.application.api;

import com.rlti.financas.contas.domain.Contas;
import com.rlti.financas.despesas.domain.Categoria;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class ContasCategoriaResponse {
    private double valorTotalParcelas;
    private Categoria categoria;

    public ContasCategoriaResponse(Contas contas){
        this.valorTotalParcelas = contas.getValorTotalParcelas();
        this.categoria = contas.getCategoria();
    }

    public static List<ContasCategoriaResponse> converte(List<Contas> contas) {
        return contas.stream()
                .map(ContasCategoriaResponse::new)
                .collect(Collectors.toList());
    }
}