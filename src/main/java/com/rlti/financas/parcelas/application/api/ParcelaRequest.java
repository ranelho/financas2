package com.rlti.financas.parcelas.application.api;

import com.rlti.financas.parcelas.domain.Situacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParcelaRequest {
    private UUID idParcela;
    private String descricao;
    private String quantidadeParcelas;
    private Double valorParcela;
    private LocalDate dataParcela;
    private Situacao situacao ;
    private UUID idDespesa;
}
