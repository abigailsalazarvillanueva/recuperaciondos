package mx.utng.recuperacionuno.model.service;

import java.util.List;

import mx.utng.recuperacionuno.model.entity.ConsumoInternet;



public interface IConsumoInternetService {
    List<ConsumoInternet> list();
    void save(ConsumoInternet consumoInternet);
    ConsumoInternet getById(Long id);
    void delete(Long id);
}
