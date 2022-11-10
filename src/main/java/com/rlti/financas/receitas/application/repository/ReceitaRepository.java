package com.rlti.financas.receitas.application.repository;

import com.rlti.financas.receitas.domain.Receita;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReceitaRepository {
    Receita salva(Receita receita);
    List<Receita> getReceitas();
    void deleta(UUID idReceita);
    Optional<Receita> buscaReceitaPorId(UUID idReceita);
}
