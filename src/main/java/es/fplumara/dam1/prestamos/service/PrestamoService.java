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
import java.util.UUID;

public class PrestamoService implements PrestamoServiceImpl{
    private Repository<Material> materialRepository;
    private Repository<Prestamo> prestamoRepository;
    @Override
    public Prestamo crearPrestamo(String idMaterial, String profesor, LocalDate fecha) {

if(profesor==null || profesor.isBlank()){
    throw new IllegalArgumentException("no existe");
}
if(fecha==null ){
    throw new IllegalArgumentException("no existe");
}
Optional<Material> opts=materialRepository.findById(idMaterial);
if(opts.isEmpty()){
    throw new MaterialNoDisponibleException("no es disponible");
}
Material material=opts.get();

if( !material.getEstado().equals(EstadoMaterial.DISPONIBLE)){
    throw new MaterialNoDisponibleException("no es disponible");
}
 String idPrestamo=UUID.randomUUID().toString();
       Prestamo prestamo=new Prestamo(idPrestamo,idMaterial,profesor,fecha);
this.prestamoRepository.save(prestamo);
material.setEstado(EstadoMaterial.PRESTADO);
this.materialRepository.save(material);
        return prestamo;
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
