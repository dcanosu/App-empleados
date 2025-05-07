package com.empleados.controller;

import java.util.List;

import com.empleados.service.EmpleadoServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empleados.model.entities.Empleado;

@RestController
public class EmpleadoController {

    private final EmpleadoServicio empleadoServicio;

    public EmpleadoController(EmpleadoServicio empleadoServicio) {
        this.empleadoServicio = empleadoServicio;
    }

    @GetMapping("/obtenerTodosEmpleados")
    public List<Empleado> obtenerTodosEmpleados() {
        return empleadoServicio.getTodosEmpleados();
    }

    @GetMapping("/obtenerEmpleadoManual")
    public List<Empleado> obtenerTodosEmpleadosManual() {
        return empleadoServicio.getTodosEmpleadosManual();
    }
}
