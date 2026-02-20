package es.fplumara.dam1.prestamos.repository;

import es.fplumara.dam1.prestamos.model.Material;

import java.util.Map;

public class MaterialRepositoryImpl extends BaseRepository<Material> {

    public MaterialRepositoryImpl(Map<String, Material> datos) {
        super(datos);
    }
}
