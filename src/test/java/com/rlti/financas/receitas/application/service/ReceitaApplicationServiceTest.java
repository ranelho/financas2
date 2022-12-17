package com.rlti.financas.receitas.application.service;

import com.rlti.financas.despesas.domain.Categoria;
import com.rlti.financas.receitas.application.api.ReceitaIdResponse;
import com.rlti.financas.receitas.application.api.ReceitaListResponse;
import com.rlti.financas.receitas.application.api.ReceitaRequest;
import com.rlti.financas.receitas.application.repository.ReceitaRepository;
import com.rlti.financas.receitas.domain.Receita;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class ReceitaApplicationServiceTest {

    @InjectMocks
    private ReceitaApplicationService classe;

    @Mock
    private ReceitaRepository receitaRepository;

    LocalDate date = LocalDate.now();
    public UUID id =UUID.fromString("08012e9c-f9b1-4f7d-ab9d-40ef39e8a41d");
    public UUID id2 =UUID.fromString("08012e9c-f9b1-4f7d-ab9d-40ef39e8a41e");

    @Test
    void criaNovaReceitaTest() {
        ReceitaRequest receitaRequest = new ReceitaRequest("TESTE", Categoria.RECEITA, date, new BigDecimal("2500"));

        when(receitaRepository.salva(new Receita(receitaRequest))).thenReturn(any());

        ReceitaIdResponse receitaIdResponse = classe.criaNovaReceita(receitaRequest);

        assertNotNull(receitaIdResponse);
        assertEquals(ReceitaIdResponse.class, receitaIdResponse.getClass());
    }

    @Test
    void getReceitasText() {
        Receita receitaRequest = new Receita(id, "teste", Categoria.RECEITA, date, new BigDecimal("2500"));
        when(receitaRepository.getReceitas()).thenReturn(List.of(receitaRequest));
        List<ReceitaListResponse> receitaListResponse = classe.getReceitas();
        assertNotNull(receitaListResponse);
        assertEquals(1,receitaListResponse.size());
        assertEquals(ReceitaListResponse.class, receitaListResponse.get(0).getClass());

        assertEquals(id, receitaListResponse.get(0).getIdReceita());
        assertEquals(date, receitaListResponse.get(0).getDataReceita());
    }

    @Test
    void detalhaReceita() {
        Optional<Receita> receitaOptional = Optional.of(new Receita());

        when(receitaRepository.buscaReceitaPorId(UUID.randomUUID())).thenReturn(receitaOptional);

    }

}