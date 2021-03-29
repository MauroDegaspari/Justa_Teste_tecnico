package com.teste.tecnico.business;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import com.teste.tecnico.dto.ConvertUnitsConvertionDTO;

public class ConvertUnitsConvertionBusiness {

	 
	public ConvertUnitsConvertionDTO getConversion(String unit)  {
			
		ConvertUnitsConvertionDTO conversorDTO = new ConvertUnitsConvertionDTO();		
						
		String Si= unit.toString();		
						
		List<String> valores = Arrays.asList("60", "3600", "84600", "0.0174533", "(3.14159265359/10800)", "(3.14159265359/68400)", "1000", "0.001", "1000");
		List<String> unidades = Arrays.asList("minute", "hour", "day", "degree", "arcminute", "arcsecond", "hectare", "lite", "tonne");
		List<String> medidMedida = Arrays.asList("s", "s", "s", "rad", "rad", "rad", "m²", "m³", "kg");

		for (int i = 0; i < unidades.size(); i++) {
			
			if (unit.contains(unidades.get(i))) {
				unit = unit.replace(unidades.get(i), valores.get(i));
				Si = Si.replace(unidades.get(i), medidMedida.get(i));
				}					
			}
		
		int posicao = unit.indexOf('/');
		String parametro1 = unit.substring(1, posicao);
		String parametro2 = unit.substring(posicao + 1, unit.length() - 1);
		
		double valor = Double.parseDouble(parametro1) / Double.parseDouble(parametro2);
		BigDecimal resultado = new BigDecimal(valor).setScale(14, RoundingMode.HALF_EVEN);
		
		
		
		conversorDTO.setUnit_name(Si.toUpperCase());
		conversorDTO.setMultiplication_factor(resultado.doubleValue());
		
		return conversorDTO;
		
	}
}

