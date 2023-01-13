package com.rlti.financas.despesas.domain;

import java.time.LocalDate;

public class ValidaMes {
	
	private static LocalDate dataPagamento = null;

	public static LocalDate validaMes(LocalDate proximoMes, int count) {		
		if (count == 1) dataPagamento = proximoMes.plusMonths(0);
		else if (count > 1) dataPagamento = proximoMes.plusMonths((count-1));
		return dataPagamento;
	}
}