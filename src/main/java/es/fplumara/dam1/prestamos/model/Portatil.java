package es.fplumara.dam1.prestamos.model;

import java.util.Set;

public class Portatil extends Material{
    private int ramGB;

    public int getRamGB() {
        return ramGB;
    }

    public void setRamGB(int ramGB) {
        this.ramGB = ramGB;
    }

    public Portatil(int ramGB) {
        this.ramGB = ramGB;
    }

    public Portatil(String id, String nombre, EstadoMaterial etado, Set<String> etiquetas, int ramGB) {
        super(id, nombre, etado, etiquetas);
        this.ramGB = ramGB;
    }

    @Override
    public String getTipo() {
        return "";
    }

    @Override
    public void setId(Long contador) {

    }
}
