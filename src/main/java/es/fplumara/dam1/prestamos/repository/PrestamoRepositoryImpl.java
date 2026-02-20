package es.fplumara.dam1.prestamos.repository;

import es.fplumara.dam1.prestamos.model.Prestamo;

import java.util.Map;

public class PrestamoRepositoryImpl extends BaseRepository<Prestamo> {

    public PrestamoRepositoryImpl(Map<String, Prestamo> datos) {
        super(datos);
    }
}
