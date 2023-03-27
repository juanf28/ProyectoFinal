package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;

public interface UsuarioServicio {

    int crearUsuario(UsuarioDTO usuarioDTO)throws Exception;

    int actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO);

    int eliminarUsuario(int codigoUsuario);

    UsuarioDTO obtenerUsuario(int codigoUsuario);

    int actualizarUsuario(String codigoUsuario, UsuarioDTO usuarioDTO)throws Exception;
}
