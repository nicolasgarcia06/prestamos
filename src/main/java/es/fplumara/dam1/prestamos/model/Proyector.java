package es.fplumara.dam1.prestamos.model;

import java.util.Set;

public class Proyector extends Material{
    private int lumens;

    public Proyector(int lumens) {
        this.lumens = lumens;
    }

    public Proyector(String id, String nombre, EstadoMaterial etado, Set<String> etiquetas, int lumens) {
        super(id, nombre, etado, etiquetas);
        this.lumens = lumens;
    }

    public int getLumens() {
        return lumens;
    }

    public void setLumens(int lumens) {
        this.lumens = lumens;
    }

    @Override
    public String getTipo() {
        return "";
    }

    @Override
    public void setId(Long contador) {

    }
}
