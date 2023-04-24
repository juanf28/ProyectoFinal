package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Compra implements Serializable {

    @Id
    @EqualsAndHashCode.Include
   private int id;

    @Column(nullable = false)
   private String idMetodoPago;


    @Column(nullable = false)
   private LocalDate fechaCompra;

    @Column(nullable = false)
   private float valorTotal;


    @Column(nullable = false)
   private int codigoUsuario;

    public Compra(Double totalCompra, LocalDateTime now, MetodoPago metodoPago, Usuario usuario) {

    }
}
