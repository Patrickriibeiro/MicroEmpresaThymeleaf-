package com.pro.empresa.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller é criar um Map do model object e encontrar uma view. 
//@RestController simplesmente retorna o objeto e os dados do objeto são gravados diretamente na resposta HTTP como JSON ou XML.
@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "/home";
	}
}
