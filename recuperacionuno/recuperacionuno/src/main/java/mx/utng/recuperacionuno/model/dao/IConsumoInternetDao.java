package mx.utng.recuperacionuno.model.dao;


import java.util.List;

import mx.utng.recuperacionuno.model.entity.ConsumoInternet;


public interface IConsumoInternetDao {
    List<ConsumoInternet> list();
    void save(ConsumoInternet consumoInternet);
    ConsumoInternet getById(Long id);
    void delete(Long id);
}
