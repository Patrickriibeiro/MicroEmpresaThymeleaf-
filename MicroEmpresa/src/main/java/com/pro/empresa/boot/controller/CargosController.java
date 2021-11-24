package com.pro.empresa.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pro.empresa.boot.domains.Cargo;
import com.pro.empresa.boot.domains.Departamento;
import com.pro.empresa.boot.service.CargoService;
import com.pro.empresa.boot.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargosController {
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos",cargoService.buscaTodos());
		return "/cargo/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Cargo cargo,BindingResult result,RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/cargo/cadastro";
		}
		
		cargoService.salvar(cargo);
		attr.addFlashAttribute("success","Cargo inserido com sucesso");
		return "redirect:/cargos/cadastrar"; // Redirecionando para chamada Rest.		
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargo",cargoService.buscarPorId(id)); // envia para o front os dados recebidos do metodo executado;
		return "/cargo/cadastro";
	}
	
	@PostMapping("/editar")
    public String editar (Cargo cargo,BindingResult result,RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/cargo/cadastro";
		}
		
		cargoService.editar(cargo);
		attr.addFlashAttribute("success", "Cargo editado com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id,RedirectAttributes attr) {
		if(cargoService.cargoTemFuncionarios(id)) {
			attr.addAttribute("fail","Cargo não removido, Tem funcionarios vinculados.");
		} else {
			cargoService.excluir(id);
			attr.addAttribute("success","Cargo excluido com sucesso");
		}
		return "redirect:/cargos/listar";
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> listaDepartamentos(){
		return departamentoService.buscaTodos();
	}


}
