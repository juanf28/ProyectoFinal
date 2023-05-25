package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ContraseñaDTO;
import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.entidades.UsuarioEmailDTO;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private UsuarioRepo usuarioRepo;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final EmailServicio emailServicio;

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


    private boolean validatePassword(String newPassword, String newPasswordRepeated) throws Exception {

        if(newPassword.equals(newPasswordRepeated) != true){
            throw new Exception("Las contraseñas no coinciden");
        }

        return true;
    }

    @Override
    public int cambiarConstrasenaAnterior(int idPerson, ContraseñaDTO passwordDTO) throws Exception {
        Usuario usuarioEncontrado = usuarioRepo.obtenerUsuario2(idPerson);

        if(usuarioEncontrado == null){
            throw new Exception("No se encontro una persona con el id " + idPerson);
        }
        String newPassword = passwordDTO.getPassword();
        String newPasswordRepeated = passwordDTO.getPasswordRepeated();

        validatePassword(newPassword,newPasswordRepeated);

        usuarioEncontrado.setContrasenia(passwordEncoder.encode(newPassword));

        usuarioRepo.save(usuarioEncontrado);
        emailServicio.enviarEmail(new EmailDTO("Se actualizó su contraseña", "Ha actualizado con exito la contraseña de su cuenta", usuarioEncontrado.getEmail()));

        return usuarioEncontrado.getCedula();
    }

    @Override
    public void recuperarContrasena(UsuarioEmailDTO usuarioEmailDTO) throws Exception {
        emailServicio.enviarEmail(new EmailDTO("Recuperar contraseña","Para recuperar su contraseña ingrese al siguiente enlace: https://www.unimarket.com/api/personas/recuperar_contraseña/" + usuarioEmailDTO.getEmail(),usuarioEmailDTO.getEmail()));


    }
    @Override
    public String cambiarContrasenaRecuperada(String emailPerson, ContraseñaDTO contraseñaDTO) throws Exception {
        Usuario usuarioEncontrado = usuarioRepo.buscarUsuario(emailPerson);

        if(usuarioEncontrado == null){
            throw new Exception("No se encontro una persona con el correo " + emailPerson);
        }

        String newPassword = contraseñaDTO.getPassword();
        String newPasswordRepeated = contraseñaDTO.getPasswordRepeated();

        validatePassword(newPassword,newPasswordRepeated);

        usuarioEncontrado.setContrasenia(passwordEncoder.encode(newPassword));

        usuarioRepo.save(usuarioEncontrado);
        emailServicio.enviarEmail(new EmailDTO("Se recuperó su contraseña", "Ha recuperado con exito la contraseña de su cuenta", usuarioEncontrado.getEmail()));

        return usuarioEncontrado.getContrasenia();
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


