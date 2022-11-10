package com.rlti.financas.despesas.domain;

import java.time.LocalDate;

public class ValidaMes {
	
	private static LocalDate dataPagameto = null;

	public static LocalDate validaMes(LocalDate proximoMes, int count) {		
		if (count == 1) dataPagameto = proximoMes.plusMonths(0);		
		else if (count > 1) dataPagameto = proximoMes.plusMonths((count-1));
		return dataPagameto;
	}
}