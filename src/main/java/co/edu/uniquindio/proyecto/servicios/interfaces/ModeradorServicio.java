package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ModeradorDTO;
import co.edu.uniquindio.proyecto.dto.ModeradorGetDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Usuario;


public interface ModeradorServicio {
    int crearModerador(ModeradorDTO moderadorDTO)throws Exception;
    Moderador obtener(int codigoModerador)throws Exception;

    ModeradorGetDTO obtenerModerador(int codigoModerador) throws Exception;
}
