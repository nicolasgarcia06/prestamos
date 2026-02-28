package es.fplumara.dam1.prestamos.Service;

import es.fplumara.dam1.prestamos.Model.Material;

import java.util.List;

public interface MaterialServiceImpl {
    void registrarMaterial(Material m);

void darDeBaja(String idMaterial);

List<Material> listar();
}
