package com.pro.empresa.boot.dao;

import java.util.List;

import com.pro.empresa.boot.domains.Cargo;

public interface CargoDao {

    void save(Cargo cargo );

    void update(Cargo cargo);

    void delete(Long id);

    Cargo findById(Long id);

    List<Cargo> findAll();
}
