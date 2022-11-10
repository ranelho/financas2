package com.rlti.financas.receitas.application.api;

import com.rlti.financas.receitas.domain.Receita;
import lombok.Builder;
import lombok.Value;

import javax.persistence.Id;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
@Builder
public class ReceitaIdResponse {
    private UUID idReceita;
}
