package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@ToString

public class DetalleCompraGetDTO {

    private int codigo;

    private int codigoProducto;
    private int idMetodoPago;

    private LocalDateTime fechaCompra;


    private float valorTotal;


    private int codigoUsuario;

    List<DetalleCompra> detalleCompraList;
}
