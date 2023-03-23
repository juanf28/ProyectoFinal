package co.edu.uniquindio.proyecto.implementacion;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;

public class UsuarioServicioImpl implements UsuarioServicio {

    private UsuarioRepo usuarioRepo;
    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO)throws Exception {


        Usuario buscado = usuarioRepo.buscarUsuario(usuarioDTO.getEmail());

        if (buscado != null){
            throw new Exception(("El correo "+ usuarioDTO.getEmail() +"ya existe"));
        }

        usuario.setNombreCompleto(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setNumTelefono(usuarioDTO.getTelefono());
        usuario.setContrasenia(usuarioDTO.getContrasenia());
        usuario.setDireccion(usuarioDTO.getDireccion());



        return usuarioRepo.save(usuario).getCedula();
    }

    @Override
    public int actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) {
        return 0;
    }
}
