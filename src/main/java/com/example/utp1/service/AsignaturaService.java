package com.example.utp1.service;

import com.example.utp1.model.Asignatura;
import com.example.utp1.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    // Obtener todas las asignaturas
    public List<Asignatura> getAsignaturas() {
        return asignaturaRepository.findAll();
    }

    // Obtener una asignatura por su id
    public Asignatura getAsignaturaById(Long id) {
        return asignaturaRepository.findById(id).orElse(null);
    }

    // Crear una nueva asignatura
    public Asignatura createAsignatura(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    // Actualizar una asignatura existente
    public Asignatura updateAsignatura(Long id, Asignatura asignatura) {
        Asignatura asignaturaActual = asignaturaRepository.findById(id).orElse(null);
        if (asignaturaActual != null) {
            asignaturaActual.setNombre(asignatura.getNombre());
            asignaturaActual.setHorario(asignatura.getHorario());
            asignaturaActual.setSeccion(asignatura.getSeccion());
            return asignaturaRepository.save(asignaturaActual);
        }
        return null;
    }

    // Eliminar una asignatura
    public void deleteAsignatura(Long id) {
        asignaturaRepository.deleteById(id);
    }
} 