package com.rlti.financas.parcelas.application.api;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.parcelas.domain.Situacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParcelaRequest {
   // private UUID idParcela;
    private Categoria categoria;
    @Size(message = "Campo descrição tarefa não pode estar vazio", min = 3, max = 255)
    private String descricao;
    @NotNull
    private String quantidadeParcelas;
    @NotNull
    private BigDecimal valorParcela;
    @NotNull
    private LocalDate dataParcela;
    @NotNull
    private Situacao situacao ;
    private UUID idDespesa;
}
