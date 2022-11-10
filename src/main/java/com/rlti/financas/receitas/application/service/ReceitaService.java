package com.rlti.financas.receitas.application.service;

import com.rlti.financas.receitas.application.api.ReceitaIdResponse;
import com.rlti.financas.receitas.application.api.ReceitaListResponse;
import com.rlti.financas.receitas.application.api.ReceitaRequest;
import com.rlti.financas.receitas.domain.Receita;

import java.util.List;
import java.util.UUID;

public interface ReceitaService {
    ReceitaIdResponse criaNovaReceita(ReceitaRequest receitaRequest);
    List<ReceitaListResponse> getReceitas();
    void deletaReceita(UUID idReceita);
    Receita detalhaReceita(UUID idReceita);
}
