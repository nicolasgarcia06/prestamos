package es.fplumara.dam1.prestamos.Service;

import es.fplumara.dam1.prestamos.Model.Prestamo;

import java.time.LocalDate;
import java.util.List;

public interface PrestamoServiceImpl {
    Prestamo crearPrestamo(String idMaterial, String profesor, LocalDate fecha);

void devolverMaterial(String idMaterial);

List<Prestamo> listarPrestamos();
}
