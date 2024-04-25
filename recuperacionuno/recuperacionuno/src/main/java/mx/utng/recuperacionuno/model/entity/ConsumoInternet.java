package mx.utng.recuperacionuno.model.entity;


    /* 
    **@author Guadalupe Abigail Salazar Villanueva
    **@grupo GDS0624
    **@DATE 22/abril/2024
    */
    
    import java.util.Date;
    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.PrePersist;
    import jakarta.persistence.Temporal;
    import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
    
    @Entity
    public class ConsumoInternet {
    
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id; // es un entero largo y grande el auto es la incrementacion 
    
        @Column (length = 40, nullable = false)
        @NotNull
    @DecimalMin(value = "0.1")
        private Double datosConsumidos; //cadena de texto es string  el nullanle = false significa que no puede ser null solo falso 

    
        @Temporal(TemporalType.DATE)
        private Date fecha; // si cambia ya que date es la fecha t
    
        @PrePersist
        public void PrePersist(){
            fecha = new Date();
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Double getDatosConsumidos() {
            return datosConsumidos;
        }

        public void setDatosConsumidos(Double datosConsumidos) {
            this.datosConsumidos = datosConsumidos;
        }

        public Date getFecha() {
            return fecha;
        }

        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }
    

        
    }