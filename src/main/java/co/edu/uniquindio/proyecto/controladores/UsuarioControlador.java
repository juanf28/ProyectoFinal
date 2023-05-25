package co.edu.uniquindio.proyecto.controladores;


import co.edu.uniquindio.proyecto.dto.ContraseñaDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.entidades.UsuarioEmailDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@AllArgsConstructor
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearUsuario(@RequestBody  UsuarioDTO usuarioDTO)  throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO(HttpStatus.CREATED, false, usuarioServicio.crearUsuario(usuarioDTO)) );
    }

    @PutMapping("/actualizar/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> actualizarUsuario(@PathVariable int codigoUsuario, @RequestBody UsuarioDTO usuarioDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, usuarioServicio.actualizarUsuario(codigoUsuario, usuarioDTO)));
    }

    @DeleteMapping("/eliminar/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> eliminiarUsuario(@PathVariable int codigoUsuario) throws Exception{
        usuarioServicio.eliminarUsuario(codigoUsuario);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, "Usuario eliminado correctamente") );
    }

    @GetMapping("/obtener/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> obtenerUsuario(@PathVariable int codigoUsuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, usuarioServicio.obtenerUsuario(codigoUsuario)));
    }

    @PutMapping("/cambiarContraseniaAnterior/{idPerson}")
    public ResponseEntity<MensajeDTO> cambiarConstrasenaAnterior(@PathVariable int idPerson, @Valid @RequestBody ContraseñaDTO passwordDTO) throws Exception{
        usuarioServicio.cambiarConstrasenaAnterior(idPerson, passwordDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Contrasenia cambiada correctamente"));
    }
    @PutMapping("/cambiarContrasenaRecuperada/{emailPerson}")
    public ResponseEntity<MensajeDTO> cambiarContrasenaRecuperada(@PathVariable String emailPerson,@Valid @RequestBody ContraseñaDTO contrasenaDTO) throws Exception{
        usuarioServicio.cambiarContrasenaRecuperada(emailPerson,contrasenaDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Contrasenia cambiada correctamente"));
    }
    @PostMapping("/recuperarContrasena/{usuarioEmailDTO}")
    public ResponseEntity<MensajeDTO> recuperarContrasena(@PathVariable UsuarioEmailDTO usuarioEmailDTO) throws Exception{
        usuarioServicio.recuperarContrasena(usuarioEmailDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Correo enviado correctamente"));
    }
}
