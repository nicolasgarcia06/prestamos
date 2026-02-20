package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.model.Prestamo;

import java.time.LocalDate;
import java.util.List;

public interface PrestamoService {
    Prestamo crearPrestamo(String id, String profesor, LocalDate fecha);
    void devolverMaterial(String idMaterial);
    List<Prestamo> listarPrestamos();
}
