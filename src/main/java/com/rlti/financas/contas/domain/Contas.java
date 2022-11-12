package com.rlti.financas.contas.domain;

import com.rlti.financas.parcelas.application.api.ParcelaListResponse;
import com.rlti.financas.parcelas.domain.Parcela;
import com.rlti.financas.receitas.application.api.ReceitaListResponse;
import com.rlti.financas.receitas.domain.Receita;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Contas {
    private double valorTotalReceitas;
    private double valorTotalParcelas;
    private double saldo;
    private List<ParcelaListResponse> parcelas;
    private List<ReceitaListResponse> receitas;


    public Contas(List<Parcela> parcelas, List<Receita> receitas) {
        this.valorTotalReceitas = receitas.stream().mapToDouble(Receita::getValor).sum();
        this.valorTotalParcelas = parcelas.stream().mapToDouble(Parcela::getValorParcela).sum();
        this.saldo = valorTotalReceitas - valorTotalParcelas;
        this.parcelas = ParcelaListResponse.converte(parcelas);
        this.receitas = ReceitaListResponse.converte(receitas);
    }
}
