package com.pro.empresa.boot.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pro.empresa.boot.dao.FuncionarioDao;
import com.pro.empresa.boot.domains.Funcionario;

@Service @Transactional(readOnly = true)
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioDao funcionarioDao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Funcionario funcionario) {
		funcionarioDao.save(funcionario);		
	}
	
	@Transactional(readOnly = false)
	@Override
	public void editar(Funcionario funcionario) {
		funcionarioDao.update(funcionario);	
	}
	
	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		funcionarioDao.delete(id);		
	}
	
	@Override
	public Funcionario buscarPorId(Long id) {
		return funcionarioDao.findById(id);
	}

	@Override
	public List<Funcionario> buscaTodos() {
		return funcionarioDao.findAll();
	}
	
	@Override
	public List<Funcionario> buscaPorNome(String nome) {
			
		return funcionarioDao.findByNome(nome);
	}

	@Override
	public List<Funcionario> buscaPorCargo(Long id) {
		
		return funcionarioDao.findByCargoId(id);
	}

	@Override
	public List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida) {
		if(entrada != null && saida != null) {
			return funcionarioDao.findByDataEntradaDataSaida(entrada,saida);
		} else if (entrada != null) {
			return funcionarioDao.findByDataEntrada(entrada);
		} else if (saida != null) {
			return funcionarioDao.findByDataSaida(saida);
		} else {
			return new ArrayList<>();
		}
	}

	
}
