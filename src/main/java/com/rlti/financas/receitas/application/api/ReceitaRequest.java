package com.rlti.financas.receitas.application.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rlti.financas.despesas.domain.Categoria;
import lombok.Value;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class ReceitaRequest {
    @NotNull
    @Size(message = "Campo descrição tarefa não pode estar vazio", min = 3, max = 255)
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataReceita;
    @NotNull
    @DecimalMin(value = "0.1", message = "Valor abaixo de: ${value}")
    private BigDecimal valor;
}
