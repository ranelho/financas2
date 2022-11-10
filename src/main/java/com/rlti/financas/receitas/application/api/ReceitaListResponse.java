package com.rlti.financas.receitas.application.api;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.receitas.domain.Receita;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ReceitaListResponse {
    private UUID idReceita;
    private String descricao;
    private Categoria categoria;
    private LocalDate dataReceita;
    private Double valor;

    public ReceitaListResponse(Receita receita){
        this.idReceita = receita.getIdReceita();
        this.descricao = receita.getDescricao();
        this.categoria = receita. getCategoria();
        this.dataReceita = receita.getDataReceita();
        this.valor = receita.getValor();
    }
    public static List<ReceitaListResponse> converte(List<Receita> listaReceitas) {
        return listaReceitas.stream()
                .map(t -> new ReceitaListResponse(t))
                .collect(Collectors.toList());
    }
}
