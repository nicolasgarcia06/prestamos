package es.fplumara.dam1.prestamos.Model;

import java.util.Set;

public class Proyector extends Material{
    private int lumenes;

    public int getLumenes() {
        return lumenes;
    }

    public void setLumenes(int lumenes) {
        this.lumenes = lumenes;
    }

    @Override
    public String getTipo() {
        return "";
    }

    public Proyector(int lumenes) {
        this.lumenes = lumenes;
    }

    public Proyector(String id, String nombre, EstadoMaterial estado, Set<String> etiquetas, int lumenes) {
        super(id, nombre, estado, etiquetas);
        this.lumenes = lumenes;
    }
}
