package mx.utng.recuperacionuno.model.service;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.recuperacionuno.model.dao.IListaDeseoDao;
import mx.utng.recuperacionuno.model.entity.ListaDeseo;






/*
 * Una clase service, esta basada en el patrón de diseño fachada
 * Es un único punto de acceso hacia los DAOs. Dentro de la clase
 * service , podemos operar con distintas clases DAO
 */
@Service
public class ListaDeseoServiceImpl implements IListaDeseoService{

    //Inyectamos la interfaz para utilizar los métodos de CRUD
    //C-Create, R-Read Retrieve, U-Update, D-Delete
    @Autowired
    private IListaDeseoDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<ListaDeseo> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(ListaDeseo listaDeseo) {
        dao.save(listaDeseo);
    }

    @Transactional(readOnly = true)
    @Override
    public ListaDeseo getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }


     
   
}
