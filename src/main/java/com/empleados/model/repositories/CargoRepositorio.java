package com.empleados.model.repositories;

import com.empleados.model.entities.Cargo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CargoRepositorio extends Repository<Cargo, Long> {

    List<Cargo> findAll();

    @Query(value = "SELECT * FROM Cargos ", nativeQuery = true)
    List<Cargo> obtenerTodosClientesManual();
}

