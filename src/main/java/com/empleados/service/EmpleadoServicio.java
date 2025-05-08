package com.empleados.service;

import com.empleados.model.entities.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoServicio {

    List<Empleado> getTodosEmpleados();
    List<Empleado> getTodosEmpleadosManual();

    // Métodos nuevos para CRUD
    Empleado guardarEmpleado(Empleado empleado);
    Empleado actualizarEmpleado(Long id, Empleado empleado);
    Optional<Empleado> obtenerEmpleadoPorId(Long id);
    void eliminarEmpleado(Long id);
}