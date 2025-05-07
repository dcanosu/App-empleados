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
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table (name = "cargos")

public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    String descripcion;

}


//    id INT AUTO_INCREMENT PRIMARY KEY,
//    nombre VARCHAR(100) NOT NULL,
//    descripcion VARCHAR(255)