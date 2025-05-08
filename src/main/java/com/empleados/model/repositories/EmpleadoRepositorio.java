package com.empleados.model.repositories;

import com.empleados.model.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {

    // Obtener todos los empleados


    // Obtener empleados manualmente
    @Query(value = "SELECT * FROM empleados", nativeQuery = true)
    List<Empleado> obtenerTodosEmpleadosManual();

}


