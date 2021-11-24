package com.pro.empresa.boot.service;

import java.time.LocalDate;
import java.util.List;

import com.pro.empresa.boot.domains.Funcionario;

public interface FuncionarioService {
	
	void salvar(Funcionario funcionario);
	
	void editar(Funcionario funcionario);
	
	void excluir(Long id);
	
	Funcionario buscarPorId(Long id);
    
    List<Funcionario> buscaTodos();

    List<Funcionario> buscaPorNome(String nome);

	List<Funcionario>  buscaPorCargo(Long id);

	List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida);

}
