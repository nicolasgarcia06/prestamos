package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.model.Material;
import es.fplumara.dam1.prestamos.model.Prestamo;
import es.fplumara.dam1.prestamos.repository.Repository;

import java.time.LocalDate;
import java.util.List;

public class PrestamoService implements PrestamoServiceImpl{
    private Repository<Material> materialRepository;
    private Repository<Prestamo> prestamoRepository;
    @Override
    public Prestamo crearPrestamo(String id, String profesor, LocalDate fecha) {
        return null;
    }

    @Override
    public void devolverMaterial(String idMaterial) {

    }

    @Override
    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.listAll();
    }
}
