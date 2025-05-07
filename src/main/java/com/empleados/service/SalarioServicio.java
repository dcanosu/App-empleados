package com.empleados.service;


import com.empleados.model.entities.Salario;


import java.util.List;

public interface SalarioServicio {
    List<Salario> getTodosSalarios();

    List<Salario>getTodosSalariosManual();
}


