package com.empleados.service.implement;

import com.empleados.model.entities.Cargo;
import com.empleados.model.repositories.CargoRepositorio;
import com.empleados.service.CargoServicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoImplementacionServicio implements CargoServicio {

    private final CargoRepositorio cargoRepositorio;

    public CargoImplementacionServicio(CargoRepositorio cargoRepositorio){
        this.cargoRepositorio = cargoRepositorio;
    }

    @Override
    public List<Cargo> getTodosCargos() {
        return cargoRepositorio.findAll();
    }

    @Override
    public List<Cargo> getTodosCargosManual() {
        return cargoRepositorio.obtenerTodosClientesManual();
    }
}
