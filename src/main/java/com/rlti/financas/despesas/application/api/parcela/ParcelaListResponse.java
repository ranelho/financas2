package com.rlti.financas.despesas.application.api.parcela;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.despesas.domain.Parcela;
import com.rlti.financas.despesas.domain.Situacao;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ParcelaListResponse {
    private UUID idParcela;
    private Categoria categoria;
    private String descricao;
    private String quantidadeParcelas;
    private BigDecimal valorParcela;
    private LocalDate dataParcela;
    private Situacao situacao ;

    public ParcelaListResponse(Parcela parcela) {
        this.idParcela = parcela.getIdParcela();
        this.categoria = parcela.getCategoria();
        this.descricao = parcela.getDescricao();
        this.quantidadeParcelas = parcela.getQuantidadeParcelas();
        this.valorParcela = parcela.getValorParcela();
        this.dataParcela = parcela.getDataParcela();
        this.situacao = parcela.getSituacao();
    }

    public static List<ParcelaListResponse> converte(List<Parcela> parcelas) {
        return parcelas.stream()
                .map(ParcelaListResponse::new)
                .collect(Collectors.toList());
    }
}
