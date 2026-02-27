package es.fplumara.dam1.prestamos.Model;

import java.util.Set;

public class Portatil extends Material {
    private int ramGB;

    public Portatil(int ramGB) {
        this.ramGB = ramGB;
    }

    public Portatil(String id, String nombre, EstadoMaterial estado, Set<String> etiquetas, int ramGB) {
        super(id, nombre, estado, etiquetas);
        this.ramGB = ramGB;
    }

    @Override
    public String getTipo() {
        return "";
    }

    public int getRamGB() {
        return ramGB;
    }

    public void setRamGB(int ramGB) {
        this.ramGB = ramGB;
    }
}
