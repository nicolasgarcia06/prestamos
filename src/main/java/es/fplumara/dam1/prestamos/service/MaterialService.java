package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.model.Material;
import es.fplumara.dam1.prestamos.repository.Repository;

import java.util.List;

public class MaterialService implements MaterialServiceImpl {
    private Repository<Material> materialRepository;
    @Override
    public void registrarMaterial(Material m) {

    }

    @Override
    public void darDeBaja(String idMaterial) {

    }

    @Override
    public List<Material> listar() {
        return List.of();
    }
}
