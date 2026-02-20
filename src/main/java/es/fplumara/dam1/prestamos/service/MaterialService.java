package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.model.Material;

import java.util.List;

public interface MaterialService {
    void registrarMaterial(Material m);
    void darDeBaja(String idMaterial);
    List<Material> listar();

}
