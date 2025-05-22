package com.empleados.service.implement;

import com.empleados.model.entities.Empleado;
import com.empleados.model.repositories.EmpleadoRepositorio;
import com.empleados.service.EmpleadoServicio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoImplementacionServicio implements EmpleadoServicio {

    private final EmpleadoRepositorio empleadoRepositorio;

    public EmpleadoImplementacionServicio(EmpleadoRepositorio empleadoRepositorio) {
        this.empleadoRepositorio = empleadoRepositorio;
    }

    @Override
    public List<Empleado> getTodosEmpleados() {
        return empleadoRepositorio.findAll(); //
    }

    @Override
    public List<Empleado> getTodosEmpleadosManual() {
        return empleadoRepositorio.obtenerTodosEmpleadosManual();
    }

    /// //////////////////////////////////////////////////////////
    // Guardar empleado
    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    // Buscar empleado por ID
    @Override
    public Optional<Empleado> obtenerEmpleadoPorId(Long id) {
        return empleadoRepositorio.findById(id);
    }

    // Actualizar empleado por ID
    // El metodo isPresent() pertenece a la clase Optional en Java. Su función es verificar si el objeto Optional contiene un valor o está vacío.
    @Override
    public void actualizarEmpleado(Empleado empleado) {
        empleadoRepositorio.buscarEmpleadoPorId(empleado.getId())
                .ifPresent(empleadoActualizable ->{
                    Empleado empleadoLimpio = empleadoActualizable.toBuilder()
                            .nombre(empleado.getNombre())
                            .email(empleado.getEmail())
                            .apellido(empleado.getApellido())
                            .cargo_id(empleado.getCargo_id())
                            .build();
                    empleadoRepositorio.save(empleadoLimpio);
        });
    }

    // Eliminar empleado por ID
    @Override
    public void eliminarEmpleado(Long id) {
        if (empleadoRepositorio.existsById(id)) {
            empleadoRepositorio.deleteById(id);
        } else {
            throw new RuntimeException("Empleado no encontrado para eliminar");
        }
    }
}
