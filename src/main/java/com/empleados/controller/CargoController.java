package com.empleados.controller;

import com.empleados.model.entities.Cargo;
import com.empleados.service.CargoServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CargoController {

    private final CargoServicio cargoServicio;

    public CargoController(CargoServicio cargoServicio) {
        this.cargoServicio = cargoServicio;
    }

    @GetMapping("/obtenerTodosCargos")
    public List<Cargo> obtenerTodosCargos() {
        return cargoServicio.getTodosCargos();
    }

    @GetMapping("/obtenerCargosManual")
    public List<Cargo> obtenerTodosCargosManual() {
        return cargoServicio.getTodosCargosManual();
    }
}
