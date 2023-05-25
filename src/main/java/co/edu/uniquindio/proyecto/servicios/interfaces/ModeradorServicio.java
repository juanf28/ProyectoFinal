package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.entidades.Estado;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Usuario;

import java.util.List;


public interface ModeradorServicio {
    int crearModerador(ModeradorDTO moderadorDTO)throws Exception;

    Moderador obtener(int codigoModerador)throws Exception;

    ModeradorGetDTO obtenerModerador(int codigoModerador) throws Exception;

    List<ProductoGetDTO> listarProductos(Estado estado) throws Exception;

    void revisarProducto (int codigoProducto) throws Exception;

    void cambiarEstado(Estado estado, int codigoProducto) throws Exception;


}
