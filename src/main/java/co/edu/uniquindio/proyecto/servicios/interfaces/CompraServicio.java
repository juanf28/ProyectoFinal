package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.entidades.Compra;

import java.util.List;

public interface CompraServicio {

    Compra crearCompra(CompraDTO compraDTO);

   List<CompraGetDTO> listarCompras(int codigoUsuario);

   CompraGetDTO obtenerCompra(int codigoCompra);


    List<CompraGetDTO> listarComprasUsuario(String cedula) throws Exception;
}
