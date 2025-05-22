package com.empleados.model.repositories;

import com.empleados.model.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {

    // Obtener todos los empleados
    @Query(value = "SELECT * FROM empleados where email =:email", nativeQuery = true)
    Optional<Empleado> buscarEmpleadoPorCorreo(@Param("email") String email);

    // Obtener empleados manualmente
    @Query(value = "SELECT * FROM empleados", nativeQuery = true)
    List<Empleado> obtenerTodosEmpleadosManual();


    @Query(value = "SELECT * FROM empleados where id=:id",nativeQuery = true)
    Optional<Empleado> buscarEmpleadoPorId(@Param("id") Long id);


}


