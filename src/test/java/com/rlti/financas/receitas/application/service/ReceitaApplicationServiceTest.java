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

    public static final UUID id = UUID.fromString("08012e9c-f9b1-4f7d-ab9d-40ef39e8a41d");
    public static final String descricao = "TESTE UNITÁRIO";
    public static final Categoria categoria = Categoria.RECEITA;
    public static final LocalDate date = LocalDate.now();
    public static final BigDecimal valor = new BigDecimal("1400");

    @InjectMocks
    private ReceitaApplicationService service;

    @Mock
    private ReceitaRepository receitaRepository;


    @Test
    void criaNovaReceitaTest() {
        ReceitaRequest receitaRequest = new ReceitaRequest(descricao, categoria, date, valor);
        Receita receitaResponse = new Receita(id, descricao, categoria, date, valor);

        when(receitaRepository.salva(any())).thenReturn(receitaResponse);
        ReceitaIdResponse receitaIdResponse = service.criaNovaReceita(receitaRequest);
        assertNotNull(receitaIdResponse);
        //assertEquals(ReceitaIdResponse.class, receitaIdResponse.getIdReceita());
        assertEquals(id, receitaIdResponse.getIdReceita());
    }

    @Test
    void getReceitasText() {
        Receita receitaResponse = new Receita(id, descricao, categoria, date, valor);
        when(receitaRepository.getReceitas()).thenReturn(List.of(receitaResponse));
        List<ReceitaListResponse> receitaListResponse = service.getReceitas();
        assertNotNull(receitaListResponse);
        assertEquals(1,receitaListResponse.size());
        assertEquals(ReceitaListResponse.class, receitaListResponse.get(0).getClass());

        assertEquals(id, receitaListResponse.get(0).getIdReceita());
        assertEquals(date, receitaListResponse.get(0).getDataReceita());
    }

    @Test
    void detalhaReceitaTeste() {
        Optional<Receita> optionalReceita = Optional.of(new Receita(id ,descricao, categoria, date, valor));
        when(receitaRepository.buscaReceitaPorId(any(UUID.class))).thenReturn(optionalReceita);
        Receita response = service.detalhaReceita(id);

        assertNotNull(response);
        assertEquals(Receita.class, response.getClass());
        assertEquals(id, response.getIdReceita());
        assertEquals(descricao, response.getDescricao());
    }
}