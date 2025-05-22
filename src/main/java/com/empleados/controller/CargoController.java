package com.empleados.controller;

import com.empleados.model.entities.Cargo;
import com.empleados.model.entities.Empleado;
import com.empleados.service.CargoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // Crear un cargo (POST)
    @PostMapping("/crearcargo")
    public String crearCargo(@RequestBody Cargo cargo) {
        try {
            cargoServicio.crearCargo(cargo);
            return "Cargo creado con éxito";
        } catch (Exception e) {
            return "Error al crear el cargo";
        }
    }

    // Obtener todos los cargos (GET)
    @GetMapping("/listarcargos")
    public List<Cargo> listarcargo() {
        return cargoServicio.getTodosCargos();
    }

    // Buscar empleado por ID (GET)
    @GetMapping("/buscar/{id}")
    public String buscarCargoPorId(@PathVariable Long id) {
        Cargo cargo = cargoServicio.cargobyid(id);
        if (cargo != null) {
            return "Cargo encontrado con exito: ";

        } else {
            return "Cargo no encontrado";
        }
    }

    // Actualizar un cargo (PUT)
    @PutMapping("/actualizarcargo/{id}")
    public ResponseEntity<String>actualizarCargo(@RequestBody Cargo cargo) {
        cargoServicio.actualizarCargo(cargo);
        return ResponseEntity.ok(" Se realizo la accion solicitada " ) ;
    }

}
