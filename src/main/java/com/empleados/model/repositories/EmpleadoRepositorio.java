package com.empleados.model.repositories;

import com.empleados.model.entities.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface EmpleadoRepositorio extends Repository<Empleado, Long> {

    List<Empleado> findAll();

    @Query(value = "SELECT * FROM cargos ", nativeQuery = true)
    List<Empleado> obtenerTodosEmpleadosManual();
}

