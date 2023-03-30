package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;

import java.util.Optional;

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

    @Override
    public int eliminarUsuario(int codigoUsuario) {
        return 0;
    }

    @Override
    public UsuarioDTO obtenerUsuario(int codigoUsuario) {
        return null;
    }

    @Override
    public int actualizarUsuario(String codigoUsuario, UsuarioDTO usuarioDTO)throws Exception {
        validarUsuario(codigoUsuario);

        Optional <Usuario> buscado = usuarioRepo.findById(codigoUsuario);

        return 0;
    }



    private void validarUsuario(String codigo)throws Exception{

        Optional<Usuario> usuario = usuarioRepo.findById(codigo);

        if (usuario.isPresent()) {
            throw new Exception("El usuario con el codigo " + codigo+ "no existe");
        }
    }
    public int eliminarUsuario(String codigo)throws Exception{

        return 0;

    }

    public UsuarioDTO obtenerUsuario(String codigoUsuario)throws Exception{
        validarUsuario(codigoUsuario);
        Usuario usuario = usuarioRepo.findBy(codigoUsuario).get();

        return usuario;
    }
    }


