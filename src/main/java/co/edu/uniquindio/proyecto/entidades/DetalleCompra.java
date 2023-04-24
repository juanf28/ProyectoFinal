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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class DetalleCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Positive
    @Column(nullable = false)
    private int unidades;

    @Positive
    @Column(nullable = false)
    private float precioProducto;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Compra compra;


}