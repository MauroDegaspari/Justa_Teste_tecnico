package com.teste.tecnico.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teste.tecnico.business.ConvertUnitsConvertionBusiness;
import com.teste.tecnico.dto.ConvertUnitsConvertionDTO;

@RestController
@RequestMapping("/units")
public class ConvertUnitsService {

	ConvertUnitsConvertionBusiness conversor = new ConvertUnitsConvertionBusiness();
	
	@RequestMapping(value = "/si", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)			
	public ConvertUnitsConvertionDTO getConverta(@RequestParam(value = "units") String units) {
	    
	    return this.conversor.getConversion(units);
	}

}
 