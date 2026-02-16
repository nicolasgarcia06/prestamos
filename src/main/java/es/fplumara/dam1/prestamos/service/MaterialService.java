package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.exception.DuplicadoException;
import es.fplumara.dam1.prestamos.exception.NoEncontradoException;
import es.fplumara.dam1.prestamos.model.EstadoMaterial;
import es.fplumara.dam1.prestamos.model.Material;
import es.fplumara.dam1.prestamos.repository.Repository;

import java.util.List;

public class MaterialService implements MaterialServiceImpl {
    private Repository<Material> materialRepository;
    @Override
    public void registrarMaterial(Material m) {
if(m.getId()!=null){
    throw new DuplicadoException("material duplicado");
}
if(m.getId()==null || m.getId().isEmpty()){
    throw new IllegalArgumentException("esta vacio");
}
    }

    @Override
    public void darDeBaja(String idMaterial) {
if(idMaterial==null){
    throw new NoEncontradoException("no existe");
}
if(idMaterial.equals(EstadoMaterial.BAJA)){
    throw new
}

    }

    @Override
    public List<Material> listar() {
        return List.of();
    }
}
