package com.rlti.financas.despesas.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class DespesaResponse {
	private UUID idDespesa;
}
