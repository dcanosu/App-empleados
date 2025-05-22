package com.empleados.service.implement;

import com.empleados.model.entities.Cargo;
import com.empleados.model.repositories.CargoRepositorio;
import com.empleados.service.CargoServicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoImplementacionServicio implements CargoServicio {
    private final CargoRepositorio cargoRepositorio;

    public CargoImplementacionServicio(CargoRepositorio cargoRepositorio) {
        this.cargoRepositorio = cargoRepositorio;
    }

    @Override
    public void actualizarCargo(Cargo cargo) {

        cargoRepositorio.cargosbyid(cargo.getId())
                .ifPresent(cargoActualizable -> {
                    Cargo cargoLimpio = cargoActualizable.toBuilder()
                            .nombre(cargo.getNombre())
                            .descripcion(cargo.getDescripcion())
                            .build();
                    cargoRepositorio.save(cargoLimpio);
                });
    }

    @Override
    public Cargo cargobyid(Long id) {
        return cargoRepositorio.cargosbyid(id).orElse(new Cargo());
    }

    @Override
    public List<Cargo> getTodosCargosManual() {
        return cargoRepositorio.obtenerTodosCargosManual();
    }

    @Override
    public List<Cargo> getTodosCargos() {
        return cargoRepositorio.findAll();
    }
}
