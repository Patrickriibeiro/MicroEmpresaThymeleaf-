package com.pro.empresa.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pro.empresa.boot.dao.CargoDao;
import com.pro.empresa.boot.domains.Cargo;

@Service @Transactional(readOnly = false) // false valor padrão
public class CargoServiceImpl implements CargoService {
	
	@Autowired
	private CargoDao cargoDao;

	@Override
	public void salvar(Cargo cargo) {
		cargoDao.save(cargo);
	}

	@Override
	public void editar(Cargo cargo) {
		cargoDao.update(cargo);
		
	}
	@Override
	public void excluir(Long id) {
		cargoDao.delete(id);
		
	}
	@Override @Transactional(readOnly = true)
	public Cargo buscarPorId(Long id) {
		return cargoDao.findById(id);
	}
	@Override @Transactional(readOnly = true)
	public List<Cargo> buscaTodos() {
		return cargoDao.findAll();
	}

	@Override
	public boolean cargoTemFuncionarios(Long id) {
		if (buscarPorId(id).getFuncionarios().isEmpty()) {
			return false;
		}
		return true;
	}
}
