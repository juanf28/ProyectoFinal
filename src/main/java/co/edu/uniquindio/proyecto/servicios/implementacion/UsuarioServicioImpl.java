package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private UsuarioRepo usuarioRepo;
    @Override
    public int crearUsuario(UsuarioDTO usuarioDTO)throws Exception {


        Usuario buscado = usuarioRepo.buscarUsuario(usuarioDTO.getEmail());

        Usuario usuario = new Usuario();

        if (buscado != null){
            throw new Exception(("El correo "+ usuarioDTO.getEmail() +"ya existe"));
        }

        usuario.setNombreCompleto(usuarioDTO.getNombre());
        usuario.setCedula(usuarioDTO.getCedula());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setNumTelefono(usuarioDTO.getTelefono());
        usuario.setContrasenia(usuarioDTO.getContrasenia());
        usuario.setDireccion(usuarioDTO.getDireccion());
        usuario.setNumTelefono(usuarioDTO.getTelefono());


        return usuarioRepo.save(usuario).getCedula();
    }

    @Override
    public  UsuarioGetDTO actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception {

        /**
         * TODO Validar que el correo no se repita
         */

        validarExiste(codigoUsuario);

        Usuario usuario = convertir(usuarioDTO);
        usuario.setCedula(codigoUsuario);

        return convertir( usuarioRepo.save(usuario) );

    }

    @Override
    public int eliminarUsuario(int codigoUsuario) throws Exception {

        validarExiste(codigoUsuario);
        usuarioRepo.deleteById(codigoUsuario);
        return codigoUsuario;

    }

    @Override
    public UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception{
        return convertir( obtener(codigoUsuario) );
    }

    @Override
    public Usuario obtener(int codigoUsuario) throws Exception{
        Optional<Usuario> usuario = usuarioRepo.findById(codigoUsuario);

        if(usuario.isEmpty() ){
            throw new Exception("El código "+codigoUsuario+" no está asociado a ningún usuario");
        }

        return usuario.get();
    }

    private void validarExiste(int codigoUsuario) throws Exception {
        boolean existe = usuarioRepo.existsById(codigoUsuario);

        if (!existe) {
            throw new Exception("El código " + codigoUsuario + " no está asociado a ningún usuario");
        }
    }

    private void validarUsuario(int codigo)throws Exception {

        Optional<Usuario> usuario = usuarioRepo.findById(codigo);

        if (usuario.isPresent()) {
            throw new Exception("El usuario con el codigo " + codigo+ "no existe");
        }
    }

    private UsuarioGetDTO convertir(Usuario usuario){

        UsuarioGetDTO usuarioDTO = new UsuarioGetDTO(
                usuario.getCedula(),
                usuario.getNombreCompleto(),
                usuario.getEmail(),
                usuario.getDireccion(),
                usuario.getNumTelefono());

        return usuarioDTO;
    }

    private Usuario convertir(UsuarioDTO usuarioDTO){

        Usuario usuario = new Usuario();
        usuario.setNombreCompleto( usuarioDTO.getNombre() );
        usuario.setEmail( usuarioDTO.getEmail() );
        usuario.setDireccion( usuarioDTO.getDireccion() );
        usuario.setNumTelefono( usuarioDTO.getTelefono() );
        usuario.setContrasenia( usuarioDTO.getContrasenia() );
        return usuario;
    }

    }


