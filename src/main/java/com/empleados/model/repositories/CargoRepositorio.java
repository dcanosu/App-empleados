package com.empleados.model.repositories;

import com.empleados.model.entities.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CargoRepositorio extends JpaRepository<Cargo, Long> {



    @Query(value = "SELECT * FROM Cargos ", nativeQuery = true)
    List<Cargo> obtenerTodosCargosManual();
    @Query(value = "SELECT * FROM Cargos WHERE id = :id", nativeQuery = true)
    Optional<Cargo> cargosbyid(@Param("id") Long id);
    @Query(value = "INSERT INTO Cargos (nombre, descripcion) VALUES (?1, ?2)", nativeQuery = true)
    void crearCargo(String nombre, String descripcion);

}

