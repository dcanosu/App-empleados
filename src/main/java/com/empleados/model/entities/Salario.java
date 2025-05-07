package com.empleados.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "empleados")

public class Salario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long empleado_id;
    String apellido;
    Date fecha_pago;
}


//    id INT AUTO_INCREMENT PRIMARY KEY,
//    empleado_id INT,
//    monto DECIMAL(10,2) NOT NULL,
//    fecha_pago DATE NOT NULL,
//    FOREIGN KEY (empleado_id) REFERENCES empleados(id)