package com.empleados.service.implement;

import com.empleados.model.entities.Salario;
import com.empleados.model.repositories.SalarioRepositorio;
import com.empleados.service.SalarioServicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalarioImplementacionServicio implements SalarioServicio {

    private final SalarioRepositorio salarioRepositorio;

    public SalarioImplementacionServicio(SalarioRepositorio salarioRepositorio){
        this.salarioRepositorio = salarioRepositorio;
    }

    @Override
    public List<Salario> getTodosSalarios() {
        return salarioRepositorio.findAll(); //
    }

    @Override
    public List<Salario> getTodosSalariosManual() {
        return salarioRepositorio.obtenerTodosClientesManual();
    }
}
