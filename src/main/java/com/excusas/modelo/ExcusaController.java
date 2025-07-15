package com.excusas.modelo;

import com.excusas.modelo.service.ExcusaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/excusas")
public class ExcusaController {

    private final ExcusaService excusaService;

    // Inyección por constructor
    public ExcusaController(ExcusaService excusaService) {
        this.excusaService = excusaService;
    }

    @PostMapping
    public ResponseEntity<String> procesarExcusa(@RequestBody ExcusaDTO dto) {
        excusaService.procesarExcusa(dto);
        return ResponseEntity.ok("Excusa procesada correctamente.");
    }

    @GetMapping
    public List<Excusa> obtenerExcusas() {
        return excusaService.obtenerExcusas();
    }
}