package com.rlti.financas.parcelas.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ParcelaIdResponse {
    private UUID idParcela;
}
