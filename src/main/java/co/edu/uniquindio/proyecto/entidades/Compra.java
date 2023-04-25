package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Compra implements Serializable {

    @Id
    private int id;

    @Column(nullable = false)
   private int idMetodoPago;


    @Column(nullable = false)
   private LocalDateTime fechaCompra;

    @Column(nullable = false)
   private float valorTotal;


    @Column(nullable = false)
   private int codigoUsuario;

    @OneToMany(mappedBy = "compra")
    ArrayList<DetalleCompra> detalleCompraList;

}
