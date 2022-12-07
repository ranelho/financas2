package com.rlti.financas.receitas.application.api;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.receitas.domain.Receita;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Value
public class ReceitaResponse {
    private UUID idReceita;
    private String descricao;
    private Categoria categoria;
    private LocalDate dataReceita;
    private BigDecimal valor;

    public ReceitaResponse(Receita receita){
        this.idReceita = receita.getIdReceita();
        this.descricao = receita.getDescricao();
        this.categoria = receita.getCategoria();
        this.dataReceita = receita.getDataReceita();
        this.valor = receita.getValor();
    }
}
