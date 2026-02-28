package es.fplumara.dam1.prestamos.Service;

import es.fplumara.dam1.prestamos.Model.EstadoMaterial;
import es.fplumara.dam1.prestamos.Model.Material;
import es.fplumara.dam1.prestamos.Repositorios.Repository;
import es.fplumara.dam1.prestamos.exception.DuplicadoException;
import es.fplumara.dam1.prestamos.exception.MaterialNoDisponible;
import es.fplumara.dam1.prestamos.exception.NoEncontradoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MaterialService implements MaterialServiceImpl{
    private Repository<Material> materialRepository;

    public MaterialService() {
    }

    public MaterialService(Repository<Material> materialRepository) {
        this.materialRepository = materialRepository;
    }

    public Repository<Material> getMaterialRepository() {
        return materialRepository;
    }

    public void setMaterialRepository(Repository<Material> materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public void registrarMaterial(Material m) {
        Optional<Material> opts=materialRepository.findById(m.getId());
        if(opts.isPresent()){
            throw new DuplicadoException("duplicado");
        }

        if(m==null || m.getId().isEmpty()){
            throw new IllegalArgumentException("no puede estar vacio");
        }
        materialRepository.save(m);
    }

    @Override
    public void darDeBaja(String idMaterial) {
Optional<Material> opts=materialRepository.findById(idMaterial);
if(opts.isEmpty()){
    throw new NoEncontradoException("no encontrado");
}
Material material= opts.get();
if(material.getEstado().equals(EstadoMaterial.BAJA)){
    throw new MaterialNoDisponible("no disponible");
}
if(material!=null && !material.getEstado().equals(EstadoMaterial.BAJA)){
    material.setEstado(EstadoMaterial.BAJA);
}
materialRepository.save(material);
    }

    @Override
    public List<Material> listar() {
        List<Material> material=materialRepository.listAll();
        return material;
    }
}
