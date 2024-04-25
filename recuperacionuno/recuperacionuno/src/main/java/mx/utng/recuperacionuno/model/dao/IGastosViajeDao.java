package mx.utng.recuperacionuno.model.dao;

import java.util.List;

import mx.utng.recuperacionuno.model.entity.GastosViaje;



public interface IGastosViajeDao {
    List<GastosViaje> list();
    void save(GastosViaje gastosViaje);
    GastosViaje getById(Long id);
    void delete(Long id);
}
