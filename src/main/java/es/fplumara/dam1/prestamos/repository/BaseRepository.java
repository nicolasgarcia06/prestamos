package es.fplumara.dam1.prestamos.repository;

import es.fplumara.dam1.prestamos.model.Identificable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BaseRepository <T extends Identificable> implements Repository<T>{
Map<String,T> datos;
private Long contador=0L;




    @Override
    public void save(T elemento) {
        if(elemento.getId()==null) {
            elemento.setId(contador);
            contador++;
        }
        datos.put(String.valueOf(contador), (T) elemento);

    }

    @Override
    public Optional<T> findById(String id) {
        return Optional.ofNullable(datos.get(id));
    }

    @Override
    public List listAll() {
        List<T> resultado = new ArrayList<>();
        for (T lista : datos.values()) {
            resultado.add(lista);
        }
        return resultado;
    }

    @Override
    public void delete(String id) {
        datos.remove(id);

    }
}
