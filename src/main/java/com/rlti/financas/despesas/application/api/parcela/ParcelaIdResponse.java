package com.rlti.financas.despesas.application.api.parcela;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ParcelaIdResponse {
    private UUID idParcela;
}
