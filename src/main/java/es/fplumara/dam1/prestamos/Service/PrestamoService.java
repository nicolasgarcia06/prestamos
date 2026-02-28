package es.fplumara.dam1.prestamos.Service;

import es.fplumara.dam1.prestamos.Model.EstadoMaterial;
import es.fplumara.dam1.prestamos.Model.Material;
import es.fplumara.dam1.prestamos.Model.Prestamo;
import es.fplumara.dam1.prestamos.Repositorios.Repository;
import es.fplumara.dam1.prestamos.exception.MaterialNoDisponible;
import es.fplumara.dam1.prestamos.exception.NoEncontradoException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PrestamoService implements PrestamoServiceImpl{
   private Repository<Material> materialRepository;
    private Repository<Prestamo> prestamoRepository;

    public PrestamoService(Repository<Material> materialRepository, Repository<Prestamo> prestamoRepository) {
        this.materialRepository = materialRepository;
        this.prestamoRepository = prestamoRepository;
    }

    public PrestamoService() {
    }

    public Repository<Material> getMaterialRepository() {
        return materialRepository;
    }

    public void setMaterialRepository(Repository<Material> materialRepository) {
        this.materialRepository = materialRepository;
    }

    public Repository<Prestamo> getPrestamoRepository() {
        return prestamoRepository;
    }

    public void setPrestamoRepository(Repository<Prestamo> prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @Override
    public Prestamo crearPrestamo(String idMaterial, String profesor, LocalDate fecha) {
        if(idMaterial==null || profesor.isEmpty()|| fecha==null){
            throw new IllegalArgumentException("no existen");
        }
        Optional<Material> opts=materialRepository.findById(idMaterial);
        if(opts.isEmpty()){
            throw new NoEncontradoException("no existe");
        }
        Material material= opts.get();
        if(!material.getEstado().equals(EstadoMaterial.DISPONIBLE)){
            throw new MaterialNoDisponible("no es disponible");
        }
        Prestamo prestamo=new Prestamo("UUID",profesor,idMaterial,fecha);
        prestamoRepository.save(prestamo);
        material.setEstado(EstadoMaterial.PRESTADO);
        materialRepository.save(material);
        return prestamo;
    }

    @Override
    public void devolverMaterial(String idMaterial) {
if(idMaterial==null){
    throw new IllegalArgumentException("no existe");
}
Optional<Material> opts=materialRepository.findById(idMaterial);
if(opts.isEmpty()){
    throw new NoEncontradoException("no existe");
}
Material material= opts.get();
if(!material.getEstado().equals(EstadoMaterial.PRESTADO)){
    throw new MaterialNoDisponible("no disponible");
}
material.setEstado(EstadoMaterial.DISPONIBLE);
materialRepository.save(material);
    }

    @Override
    public List<Prestamo> listarPrestamos() {
        List<Prestamo> prestamo=prestamoRepository.listAll();
        return prestamo;
    }
}
