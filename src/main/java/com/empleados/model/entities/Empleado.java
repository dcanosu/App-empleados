package com.empleados.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.Table;

@Entity
@Setter
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "empleados")

public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private Long cargo_id;
}


//id INT AUTO_INCREMENT PRIMARY KEY,
//    nombre VARCHAR(100) NOT NULL,
//    apellido VARCHAR(100) NOT NULL,
//    email VARCHAR(150) UNIQUE,
//    cargo_id INT,
//    FOREIGN KEY (cargo_id) REFERENCES cargos(id)