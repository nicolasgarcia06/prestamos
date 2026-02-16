package es.fplumara.dam1.prestamos.service;

import es.fplumara.dam1.prestamos.exception.MaterialNoDisponibleException;
import es.fplumara.dam1.prestamos.exception.NoEncontradoException;
import es.fplumara.dam1.prestamos.model.EstadoMaterial;
import es.fplumara.dam1.prestamos.model.Material;
import es.fplumara.dam1.prestamos.model.Prestamo;
import es.fplumara.dam1.prestamos.repository.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PrestamoService implements PrestamoServiceImpl{
    private Repository<Material> materialRepository;
    private Repository<Prestamo> prestamoRepository;
    @Override
    public Prestamo crearPrestamo(String id, String profesor, LocalDate fecha) {
        return null;
    }

    @Override
    public void devolverMaterial(String idMaterial) {
Optional<Material> opt=materialRepository.findById(idMaterial);
Material material=opt.get();
if(material==null){
    throw new NoEncontradoException("no existe");
}
if (idMaterial==null || idMaterial.isBlank()){
    throw new IllegalArgumentException("no existe");
}
if(material!=null && !material.getEstado().equals(EstadoMaterial.PRESTADO)){
    throw new MaterialNoDisponibleException("su estado no es prestado");
}
if(!material.getEstado().equals(EstadoMaterial.DISPONIBLE)){
    material.setEstado(EstadoMaterial.DISPONIBLE);
    materialRepository.save(material);
}

    }

    @Override
    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.listAll();
    }
}
