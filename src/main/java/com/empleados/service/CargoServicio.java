package com.empleados.service;

import com.empleados.model.entities.Cargo;



import java.util.List;

public interface CargoServicio {
    List<Cargo> getTodosCargos();

    List<Cargo> getTodosCargosManual();
    void actualizarCargo(Cargo cargo);
    Cargo cargobyid(Long id);

}
