package com.example.utp1.controller;

import com.example.utp1.model.Asignatura;
import com.example.utp1.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    // Obtener todas las asignaturas
    @GetMapping
    public List<Asignatura> getAllAsignaturas() {
        return asignaturaService.getAsignaturas();
    }

    // Obtener una asignatura por su id
    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> getAsignaturaById(@PathVariable Long id) {
        Asignatura asignatura = asignaturaService.getAsignaturaById(id);
        if (asignatura != null) {
            return ResponseEntity.ok(asignatura);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear una nueva asignatura
    @PostMapping
    public Asignatura createAsignatura(@RequestBody Asignatura asignatura) {
        return asignaturaService.createAsignatura(asignatura);
    }

    // Actualizar una asignatura existente
    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> updateAsignatura(@PathVariable Long id, @RequestBody Asignatura asignatura) {
        Asignatura updatedAsignatura = asignaturaService.updateAsignatura(id, asignatura);
        if (updatedAsignatura != null) {
            return ResponseEntity.ok(updatedAsignatura);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar una asignatura
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsignatura(@PathVariable Long id) {
        asignaturaService.deleteAsignatura(id);
        return ResponseEntity.noContent().build();
    }
} 