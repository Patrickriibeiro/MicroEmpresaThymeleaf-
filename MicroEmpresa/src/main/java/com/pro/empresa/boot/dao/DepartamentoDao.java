package com.pro.empresa.boot.dao;

import java.util.List;

import com.pro.empresa.boot.domains.Departamento;

public interface DepartamentoDao {

    void save(Departamento departamento);

    void update(Departamento departamento);

    void delete(Long id);

    Departamento findById(Long id);

    List<Departamento> findAll();
}
