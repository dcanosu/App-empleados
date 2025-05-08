package com.empleados.controller;

import java.util.List;

import com.empleados.service.EmpleadoServicio;
import org.springframework.web.bind.annotation.*;

import com.empleados.model.entities.Empleado;

@RestController
@RequestMapping("/empleados")
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


    // Crear un empleado (POST)
    @PostMapping("/crear")
    public String crearEmpleado(@RequestBody Empleado empleado) {
        try {
            empleadoServicio.guardarEmpleado(empleado);
            return "Empleado creado con éxito";
        } catch (Exception e) {
            return "Error al crear el empleado";
        }
    }

    // Obtener todos los empleados (GET)
    @GetMapping("/listar")
    public List<Empleado> listarEmpleados() {
        return empleadoServicio.getTodosEmpleados();
    }

    // Buscar empleado por ID (GET)
    @GetMapping("/buscar/{id}")
    public String buscarEmpleadoPorId(@PathVariable Long id) {
        Empleado empleado = empleadoServicio.obtenerEmpleadoPorId(id).orElse(null);
        if (empleado != null) {
            return "Empleado encontrado: " + empleado.getNombre() + " " + empleado.getApellido();
        } else {
            return "Empleado no encontrado";
        }
    }

    // Actualizar un empleado (PUT)
    @PutMapping("/actualizar/{id}")
    public String actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        Empleado actualizado = empleadoServicio.actualizarEmpleado(id, empleado);
        if (actualizado != null) {
            return "Empleado actualizado: " + actualizado.getNombre();
        } else {
            return "Error al actualizar el empleado";
        }
    }

    // Eliminar un empleado (DELETE)
    @DeleteMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
        try {
            empleadoServicio.eliminarEmpleado(id);
            return "Empleado eliminado con éxito";
        } catch (Exception e) {
            return "Error al eliminar el empleado";
        }
    }

}
