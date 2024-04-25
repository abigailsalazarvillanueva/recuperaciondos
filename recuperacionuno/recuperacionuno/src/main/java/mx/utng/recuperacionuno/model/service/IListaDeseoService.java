package mx.utng.recuperacionuno.model.service;

import java.util.List;

import mx.utng.recuperacionuno.model.entity.ListaDeseo;



public interface IListaDeseoService {
    List<ListaDeseo> list();
    void save(ListaDeseo listaDeseo);
    ListaDeseo getById(Long id);
    void delete(Long id);
}
