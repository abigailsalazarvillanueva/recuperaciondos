package mx.utng.recuperacionuno.model.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.recuperacionuno.model.entity.ListaDeseo;





@Repository
public class ListaDeseoDaoImpl implements IListaDeseoDao{

   
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<ListaDeseo> list() {
        return em.createQuery("from ListaDeseo").getResultList();
    }

    @Override
    public void save(ListaDeseo listaDeseo) {
        System.out.println("ListaDeseo id="+listaDeseo.getId());
        if(listaDeseo.getId() != null && listaDeseo.getId() >0){
            //Actualizo estudiante
            em.merge(listaDeseo);
        }else{
            //Creamos nuevo estudiante en la base
            em.persist(listaDeseo);
        }
    }

    @Override
    public ListaDeseo getById(Long id) {
        return em.find(ListaDeseo.class, id);
    }

    @Override
    public void delete(Long id) {
        ListaDeseo listaDeseo = getById(id);
        em.remove(listaDeseo);
    }



    
}