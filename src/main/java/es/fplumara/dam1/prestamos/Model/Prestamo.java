package es.fplumara.dam1.prestamos.Model;

import java.time.LocalDate;

public class Prestamo implements Identificable{
   private String id;

 private String idMaterial;

private String profesor;
private    LocalDate fecha;

    public Prestamo() {
    }

    public Prestamo(String id, String profesor, String idMaterial, LocalDate fecha) {
        this.id = id;
        this.profesor = profesor;
        this.idMaterial = idMaterial;
        this.fecha = fecha;
    }

    @Override
    public String getId() {
        return "";
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
}
