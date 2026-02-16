package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.exception.DuplicadoException;
import es.fplumara.dam1.prestamos.exception.MaterialNoDisponibleException;
import es.fplumara.dam1.prestamos.exception.NoEncontradoException;
import es.fplumara.dam1.prestamos.model.EstadoMaterial;
import es.fplumara.dam1.prestamos.model.Material;
import es.fplumara.dam1.prestamos.repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MaterialService implements MaterialServiceImpl {
    private Repository<Material> materialRepository;
    @Override
    public void registrarMaterial(Material m) {
        Optional<Material> material=materialRepository.findById(m.getId());
        if(material!=null){
            throw new DuplicadoException("no existe");
        }
if(m.getId()==null || m.getId().isEmpty()){
    throw new IllegalArgumentException("esta vacio");
}
    }

    @Override
    public void darDeBaja(String idMaterial) {
Optional<Material> material=materialRepository.findById(idMaterial);
if(material==null){
    throw new NoEncontradoException("no existe");
}

    }

    @Override
    public List<Material> listar() {
       return materialRepository.listAll();
    }
}
