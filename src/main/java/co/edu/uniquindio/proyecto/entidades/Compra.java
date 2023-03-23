package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Compra {

    @Id
    @EqualsAndHashCode.Include
   private String id;

   private String idMetodoPago;
   private String idFuncion;

   private LocalDate fechaCompra;
   private double valorTotal;


}
