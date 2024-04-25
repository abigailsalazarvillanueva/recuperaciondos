package mx.utng.recuperacionuno.model.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.recuperacionuno.model.dao.IConsumoInternetDao;
import mx.utng.recuperacionuno.model.entity.ConsumoInternet;





/*
 * Una clase service, esta basada en el patrón de diseño fachada
 * Es un único punto de acceso hacia los DAOs. Dentro de la clase
 * service , podemos operar con distintas clases DAO
 */
@Service
public class ConsumoInternetServiceImpl implements IConsumoInternetService{

    //Inyectamos la interfaz para utilizar los métodos de CRUD
    //C-Create, R-Read Retrieve, U-Update, D-Delete
    @Autowired
    private IConsumoInternetDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<ConsumoInternet> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(ConsumoInternet consumoInternet) {
        dao.save(consumoInternet);
    }

    @Transactional(readOnly = true)
    @Override
    public ConsumoInternet getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

     
   
}
