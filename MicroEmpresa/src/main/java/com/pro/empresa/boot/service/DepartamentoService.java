package com.pro.empresa.boot.service;

import java.util.List;

import com.pro.empresa.boot.domains.Departamento;

public interface DepartamentoService {

    void salvar(Departamento departamento);
	
	void editar(Departamento departamento);
	
	void excluir(Long id);
	
    Departamento buscarPorId(Long id);
    
    List<Departamento> buscaTodos();

	boolean departamentoTemCargos(Long id);
}
