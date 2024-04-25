package mx.utng.recuperacionuno.model.service;



import java.util.List;

import mx.utng.recuperacionuno.model.entity.GastosViaje;





public interface IGastosViajeService {
    List<GastosViaje> list();
    void save(GastosViaje gastosViaje);
    GastosViaje getById(Long id);
    void delete(Long id);
}
