package com.empleados.service.implement;

import com.empleados.model.entities.Empleado;
import com.empleados.model.repositories.EmpleadoRepositorio;
import com.empleados.service.EmpleadoServicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoImplementacionServicio implements EmpleadoServicio {

    private final EmpleadoRepositorio empleadoRepositorio;

    public EmpleadoImplementacionServicio(EmpleadoRepositorio empleadoRepositorio){
        this.empleadoRepositorio = empleadoRepositorio;
    }

    @Override
    public List<Empleado> getTodosEmpleados() {
        return empleadoRepositorio.findAll(); //
    }

    @Override
    public List<Empleado> getTodosEmpleadosManual() {
        return empleadoRepositorio.obtenerTodosEmpleadosManual();
    }
}
