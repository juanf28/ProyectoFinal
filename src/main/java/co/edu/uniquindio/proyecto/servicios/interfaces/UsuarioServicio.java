package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;

public interface UsuarioServicio {

    int crearUsuario(UsuarioDTO usuarioDTO)throws Exception;

    int actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO)throws Exception;

    int eliminarUsuario(int codigoUsuario)throws Exception;

    UsuarioDTO obtenerUsuario(int codigoUsuario)throws Exception;

    int actualizarUsuario(String codigoUsuario, UsuarioDTO usuarioDTO)throws Exception;
}
