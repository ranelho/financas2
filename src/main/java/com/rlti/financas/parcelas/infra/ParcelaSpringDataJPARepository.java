package com.rlti.financas.parcelas.infra;

import com.rlti.financas.despesas.domain.Despesa;
import com.rlti.financas.parcelas.domain.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ParcelaSpringDataJPARepository extends JpaRepository<Parcela, UUID> {
}
