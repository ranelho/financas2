package com.rlti.financas.receitas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.receitas.application.api.ReceitaAlteracaoRequest;
import com.rlti.financas.receitas.application.api.ReceitaRequest;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Receita {
    @Id
    @Column(name = "id_Receita", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID idReceita;
    @NotBlank
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataReceita;
    @NotNull
    private BigDecimal valor;

    public Receita(ReceitaRequest receitaRequest){
        this.idReceita = UUID.randomUUID();
        this.descricao = receitaRequest.getDescricao();
        this.categoria = Categoria.validaCategoria(receitaRequest.getCategoria());
        this.dataReceita = receitaRequest.getDataReceita();
        this.valor = receitaRequest.getValor();
    }

    public void altera(ReceitaAlteracaoRequest receitaAlteracaoRequest) {
        this.descricao = receitaAlteracaoRequest.getDescricao();
        this.categoria = receitaAlteracaoRequest.getCategoria();
        this.dataReceita = receitaAlteracaoRequest.getDataReceita();
        this.valor = receitaAlteracaoRequest.getValor();
    }
}
