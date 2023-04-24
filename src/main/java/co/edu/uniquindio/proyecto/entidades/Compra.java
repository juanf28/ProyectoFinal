package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public Compra(Double totalCompra, LocalDateTime now, MetodoPago metodoPago, Usuario usuario) {

    }
}
