package com.rlti.financas.contas.domain;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.despesas.application.api.parcela.ParcelaListResponse;
import com.rlti.financas.despesas.domain.Parcela;
import com.rlti.financas.receitas.application.api.ReceitaListResponse;
import com.rlti.financas.receitas.domain.Receita;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Contas {
    private BigDecimal valorTotalReceitas;
    private BigDecimal valorTotalParcelas;
    private Categoria categoria;
    private BigDecimal saldoGeral;
    private List<ParcelaListResponse> parcelas;
    private List<ReceitaListResponse> receitas;

    public Contas(List<Parcela> parcelas, List<Receita> receitas) {
        this.valorTotalReceitas = somaReceitas(receitas);
        this.valorTotalParcelas = somaParcelas(parcelas);
        this.saldoGeral = valorTotalReceitas.subtract(valorTotalParcelas);
        this.parcelas = ParcelaListResponse.converte(parcelas);
        this.receitas = ReceitaListResponse.converte(receitas);
    }
    public Contas(Categoria categoria, List<Parcela> parcelas) {
        this.categoria = categoria;
        this.valorTotalParcelas = somaParcelas(parcelas);
    }
    private BigDecimal somaParcelas(List<Parcela> parcelas){
        return parcelas
               .stream()
               .map(Parcela::getValorParcela)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    private BigDecimal somaReceitas(List<Receita> receitas){
        return receitas
               .stream()
               .map(Receita::getValor)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
