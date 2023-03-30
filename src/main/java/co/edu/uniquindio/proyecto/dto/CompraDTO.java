package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.entidades.MetodoPago;

import java.util.List;

public class CompraDTO {

    private int codigoUsuario;
    private MetodoPago metodoPago;
    private List<DetalleCompraDTO> detalleCompraDTO;

}
