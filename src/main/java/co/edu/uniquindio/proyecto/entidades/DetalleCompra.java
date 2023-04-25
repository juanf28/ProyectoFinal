package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetalleCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Positive
    @Column(nullable = false)
    private int unidades;

    @Positive
    @Column(nullable = false)
    private float precioProducto;

    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "codigo_compra")
    private Compra compra;


}