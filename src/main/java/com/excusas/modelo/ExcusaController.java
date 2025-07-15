package com.excusas.modelo;

import com.excusas.modelo.empleados.Empleado;
import com.excusas.modelo.encargados.Encargado;
import com.excusas.modelo.encargados.LineaDeEncargados;
import com.excusas.modelo.excusas.Excusa;
import com.excusas.modelo.excusas.MotivoExcusa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/excusas")
public class ExcusaController {

    private final List<Excusa> excusas = new ArrayList<>();
    private final Encargado linea;

    public ExcusaController() {
        this.linea = LineaDeEncargados.crearLinea(); // armás la cadena de responsables
    }

    @PostMapping
    public ResponseEntity<String> procesarExcusa(@RequestBody ExcusaDTO dto) {
        Empleado empleado = new Empleado(dto.getNombre(), dto.getEmail(), dto.getLegajo());
        Excusa excusa = new Excusa(empleado, dto.getMotivo());

        excusas.add(excusa);
        linea.manejarExcusa(excusa); // se procesa por la cadena

        return ResponseEntity.ok("Excusa procesada correctamente.");
    }

    @GetMapping
    public List<Excusa> obtenerExcusas() {
        return excusas;
    }
}