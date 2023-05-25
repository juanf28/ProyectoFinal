package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.entidades.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CompraGetDTO {


   private Integer idCompra;
    private int codigoUsuario;
    private MetodoPago MetodoPago;
    private List<DetalleCompra> detalleCompra;

    private LocalDateTime fechaCompra;
    private float valorTotal;
}
