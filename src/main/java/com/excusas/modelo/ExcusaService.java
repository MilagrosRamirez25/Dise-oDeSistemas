package com.excusas.modelo;


import com.excusas.modelo.encargados.Encargado;
import com.excusas.modelo.encargados.LineaDeEncargados;
import com.excusas.modelo.excusas.Excusa;
import com.excusas.modelo.ExcusaDTO;
import com.excusas.modelo.empleados.Empleado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExcusaService {

    private final List<Excusa> excusas = new ArrayList<>();
    private final Encargado linea;

    public ExcusaService() {
        this.linea = LineaDeEncargados.crearLinea();
    }

    public void procesarExcusa(ExcusaDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("El DTO no puede ser nulo");
        }
        if (dto.getNombre() == null || dto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (dto.getEmail() == null || dto.getEmail().isBlank()) {
            throw new IllegalArgumentException("El email es obligatorio");
        }
        if (dto.getLegajo() <= 0) {
            throw new IllegalArgumentException("El legajo debe ser un número positivo");
        }

        Empleado empleado = new Empleado(dto.getNombre(), dto.getEmail(), dto.getLegajo());
        Excusa excusa = new Excusa(empleado, dto.getMotivo());
        excusas.add(excusa);

        linea.manejarExcusa(excusa);
    }

    public List<Excusa> obtenerExcusas() {
        return new ArrayList<>(excusas);
    }
}
