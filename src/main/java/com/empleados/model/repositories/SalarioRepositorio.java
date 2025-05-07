package com.empleados.model.repositories;

import com.empleados.model.entities.Empleado;
import com.empleados.model.entities.Salario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SalarioRepositorio extends Repository<Salario, Long> {

    List<Salario> findAll();

    @Query(value = "SELECT * FROM salarios ", nativeQuery = true)
    List<Salario> obtenerTodosClientesManual();
}

