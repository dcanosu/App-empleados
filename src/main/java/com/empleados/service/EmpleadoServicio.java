package com.empleados.service;

import com.empleados.model.entities.Empleado;

import java.util.List;

public interface EmpleadoServicio {

    List<Empleado> getTodosEmpleados();

    List<Empleado>getTodosEmpleadosManual();
}
