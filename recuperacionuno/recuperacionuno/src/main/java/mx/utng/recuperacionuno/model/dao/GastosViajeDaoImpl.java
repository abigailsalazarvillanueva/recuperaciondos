package mx.utng.recuperacionuno.model.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.recuperacionuno.model.entity.GastosViaje;





@Repository
public class GastosViajeDaoImpl implements IGastosViajeDao{

   
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<GastosViaje> list() {
        return em.createQuery("from GastosViaje").getResultList();
    }

    @Override
    public void save(GastosViaje gastosViaje) {
        System.out.println("GastosViaje id="+gastosViaje.getId());
        if(gastosViaje.getId() != null && gastosViaje.getId() >0){
            //Actualizo estudiante
            em.merge(gastosViaje);
        }else{
            //Creamos nuevo estudiante en la base
            em.persist(gastosViaje);
        }
    }

    @Override
    public GastosViaje getById(Long id) {
        return em.find(GastosViaje.class, id);
    }

    @Override
    public void delete(Long id) {
        GastosViaje gastosViaje = getById(id);
        em.remove(gastosViaje);
    }

   

    
}