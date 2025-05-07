package com.empleados.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.empleados.service.SalarioServicio;
import com.empleados.model.entities.Salario; // Suponiendo que existe esta clase
import java.util.List;

@RestController
public class SalarioController {

    private final SalarioServicio salarioServicio;

    public SalarioController(SalarioServicio salarioServicio) {
        this.salarioServicio = salarioServicio;
    }

    @GetMapping("/obtenerTodosSalarios")
    public List<Salario> obtenerTodosSalarios() {
        return salarioServicio.getTodosSalarios();
    }

    @GetMapping("/obtenerSalariosManual")
    public List<Salario> obtenerTodosSalariosManual() {
        return salarioServicio.getTodosSalariosManual();
    }
}
