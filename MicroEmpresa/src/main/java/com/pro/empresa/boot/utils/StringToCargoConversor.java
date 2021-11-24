package com.pro.empresa.boot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

import com.pro.empresa.boot.domains.Cargo;
import com.pro.empresa.boot.service.CargoService;

@Component
public class StringToCargoConversor implements Converter<String,Cargo> {
	
	@Autowired
	private CargoService cargoService;
	
	@Override
	public Cargo convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text); // retorna um objeto Long com o valor da string
		return cargoService.buscarPorId(id);
	}

}
