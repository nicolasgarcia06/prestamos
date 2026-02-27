package es.fplumara.dam1.prestamos.Repositorios;

import es.fplumara.dam1.prestamos.Model.Identificable;

import java.util.*;

public class BaseRepository<T extends Identificable>implements Repository<T>{
    private Map<String,T> datos;

    public BaseRepository() {
        this.datos=new HashMap<>();
    }

    public BaseRepository(Map<String, T> datos) {
        this.datos = datos;
    }

    @Override
    public void save(T elemento) {
datos.put(elemento.getId(), elemento);
    }

    @Override
    public Optional<T> findById(String id) {
        if(id==null){
            return Optional.empty();
        }
return Optional.ofNullable(datos.get(id));

    }

    @Override
    public List<T> listAll() {
        List<T>resultado=new ArrayList<>();
        for(T r:datos.values()){
            resultado.add(r);
        }
        return resultado;
    }

    @Override
    public void delete(String id) {
datos.remove(id);
    }
}
