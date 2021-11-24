package com.pro.empresa.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pro.empresa.boot.dao.DepartamentoDao;
import com.pro.empresa.boot.domains.Departamento;

@Service @Transactional(readOnly = false) // false valor padrão
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Override
	public void salvar(Departamento departamento) {
		departamentoDao.save(departamento);	
	}

	@Override
	public void editar(Departamento departamento) {
		departamentoDao.update(departamento);		
	}

	@Override
	public void excluir(Long id) {
		departamentoDao.delete(id);			
	}

	@Override @Transactional(readOnly = true)
	public Departamento buscarPorId(Long id) {
		return departamentoDao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Departamento> buscaTodos() {
		return departamentoDao.findAll();
	}

	@Override
	public boolean departamentoTemCargos(Long id) {
		if (buscarPorId(id).getCargos().isEmpty()) {
			return false;
		}
		return true;
	}
}
