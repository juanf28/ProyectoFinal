package co.edu.uniquindio.proyecto.entidades;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class DetalleCompra {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 100, nullable = false)
    private int codigo;

    @Column(length = 100, nullable = false)
    private int unidades;

    @Column( nullable = false)
    private float precioProducto;
    @Column(length = 100, nullable = false)
    private int codigoCompra;
    @Column(length = 100, nullable = false)
    private int codigoProducto;

}
