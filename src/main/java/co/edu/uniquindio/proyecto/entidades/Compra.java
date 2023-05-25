package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
   private MetodoPago MetodoPago;


    @Column(nullable = false)
   private LocalDateTime fechaCompra;

    @Column(nullable = false)
   private float valorTotal;


    @Column(nullable = false)
   private int codigoUsuario;


    @OneToMany(mappedBy = "compra")
    List<DetalleCompra> detalleCompraList;

}
