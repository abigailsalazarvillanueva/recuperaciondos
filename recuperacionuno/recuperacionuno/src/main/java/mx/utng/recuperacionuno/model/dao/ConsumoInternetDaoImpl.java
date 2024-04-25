package mx.utng.recuperacionuno.model.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.recuperacionuno.model.entity.ConsumoInternet;





@Repository
public class ConsumoInternetDaoImpl implements IConsumoInternetDao{

   
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<ConsumoInternet> list() {
        return em.createQuery("from ConsumoInternet").getResultList();
    }

    @Override
    public void save(ConsumoInternet consumoInternet) {
        System.out.println("ConsumoInternet id="+consumoInternet.getId());
        if(consumoInternet.getId() != null && consumoInternet.getId() >0){
            //Actualizo estudiante
            em.merge(consumoInternet);
        }else{
            //Creamos nuevo estudiante en la base
            em.persist(consumoInternet);
        }
    }

    @Override
    public ConsumoInternet getById(Long id) {
        return em.find(ConsumoInternet.class, id);
    }

    @Override
    public void delete(Long id) {
        ConsumoInternet consumoInternet = getById(id);
        em.remove(consumoInternet);
    }


    
}