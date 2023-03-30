package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.service.spi.ServiceBinding;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Compra implements Serializable {

    @Id
    @EqualsAndHashCode.Include
   private int id;

   private String idMetodoPago;


   private LocalDate fechaCompra;
   private float valorTotal;

   private int codigoUsuario;

}
