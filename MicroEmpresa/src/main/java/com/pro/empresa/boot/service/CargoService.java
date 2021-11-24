package com.pro.empresa.boot.service;

import java.util.List;

import com.pro.empresa.boot.domains.Cargo;

public interface CargoService {
	
	void salvar(Cargo cargo);
	
	void editar(Cargo cargo);
	
	void excluir(Long id);
	
    Cargo buscarPorId(Long id);
    
    List<Cargo> buscaTodos();

	boolean cargoTemFuncionarios(Long id);

}
