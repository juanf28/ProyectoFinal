package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.entidades.Usuario;

public interface UsuarioServicio {

    int crearUsuario(UsuarioDTO usuarioDTO)throws Exception;

    UsuarioGetDTO actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception;

    int eliminarUsuario(int codigoUsuario)throws Exception;

    Usuario obtener(int codigoUsuario)throws Exception;

    UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception;


}
