package com.pro.empresa.boot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.pro.empresa.boot.domains.Departamento;
import com.pro.empresa.boot.service.DepartamentoService;

@Component
public class StringToDepartamentoConverter implements Converter<String,Departamento>  {
	
	@Autowired
	private DepartamentoService departamentoService;

	@Override
	public Departamento convert(String text) {
		
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text); // retorna um objeto Long com o valor da string
		return departamentoService.buscarPorId(id);
	}

}
