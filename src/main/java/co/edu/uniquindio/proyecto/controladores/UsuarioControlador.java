package co.edu.uniquindio.proyecto.controladores;


import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio =null;

    @PostMapping("/crear")
    public int crearUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {

        return usuarioServicio.crearUsuario(usuarioDTO);
    }
    @PostMapping("/actualizar/{codigoUsuario}")
    public UsuarioGetDTO actualizarUsuario(@PathVariable int codigoUsuario, @RequestBody UsuarioDTO usuarioDTO) throws Exception{
        return usuarioServicio.actualizarUsuario(codigoUsuario, usuarioDTO);
    }

    @PostMapping("/eliminar/{codigoUsuario}")
    public void eliminarUsuario(@PathVariable int codigoUsuario) throws Exception {
        usuarioServicio.eliminarUsuario(codigoUsuario);
    }

   // public UsuarioGetDTO obtenerUsuarios(@RequestBody ) throws Exception {

   //}


}
