package com.rlti.financas.receitas.infra;

import com.rlti.financas.receitas.domain.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReceitaSpringDataJPARepository extends JpaRepository<Receita, UUID> {
}
