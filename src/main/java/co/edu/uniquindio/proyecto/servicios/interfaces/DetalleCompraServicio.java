package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.entidades.Producto;

import java.util.List;

public interface DetalleCompraServicio {

    DetalleCompra crearDetalleCompra(DetalleCompraDTO detalleCompraDTO, Compra compra) throws Exception;

    DetalleCompraGetDTO obtenerDetalleCompra(int codigoDetalleCompra) throws Exception;


    List<DetalleCompraGetDTO> listarProductosUsuario(int codigoUsuario) throws Exception;


    List<Integer> obtenerDetallesCodigo(List<DetalleCompra> compras) throws Exception;

    void actualizarUnidades(Producto product, int unities);

}
