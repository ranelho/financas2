package com.rlti.financas.despesas.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.rlti.financas.handler.APIException;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public enum Categoria {
    CARTÃO,
    MORADIA,
    EMPRÉSTIMO,
    CUIDADOS_PESSOAIS,
    TELEFONIA,
    POUPANÇA,
    OUTROS,
    SUPERMERCADO,
    ALIMENTAÇÃO,
    TAXAS,
    EDUCAÇÃO,
    SAÚDE,
    TRANSPORTE,
    RECEITA,
    MOBILIÁRIO,
    ELETRODOMÉSTICOS;

    public static Categoria validaCategoria(Categoria categoria) {
       Optional<Categoria> optionalCategoria = Optional.ofNullable(fromValue(String.valueOf(categoria)));
        if (optionalCategoria.isPresent()){
            return Categoria.valueOf(String.valueOf(categoria));
        }else{
           throw APIException.build(HttpStatus.NOT_FOUND, "Categoria não encontrada!");
        }
    }
    @JsonCreator
    public static Categoria fromValue(String name) {
        try {
            return Categoria.valueOf(name);
        } catch (IllegalArgumentException e) {
            return null; // if nor enum instance available for name, then use the default one.
        }
    }
}
