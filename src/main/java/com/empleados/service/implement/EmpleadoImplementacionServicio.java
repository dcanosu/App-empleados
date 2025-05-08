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

    public EmpleadoImplementacionServicio(EmpleadoRepositorio empleadoRepositorio){
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
    /////////////////////////////////////////////////////////////
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
    public Empleado actualizarEmpleado(Long id, Empleado empleado) {
        Optional<Empleado> empleadoExistente = empleadoRepositorio.findById(id);

        if (empleadoExistente.isPresent()) {
            Empleado empleadoActualizado = empleadoExistente.get();
            empleadoActualizado.setNombre(empleado.getNombre());
            empleadoActualizado.setApellido(empleado.getApellido());
            empleadoActualizado.setEmail(empleado.getEmail());
            empleadoActualizado.setCargo_id(empleado.getCargo_id());
            return empleadoRepositorio.save(empleadoActualizado);
        } else {
            throw new RuntimeException("Empleado no encontrado");
        }
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
