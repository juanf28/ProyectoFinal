package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsuarioServicioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Test
    public void registrarUsuarioTest(){

        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO((nombre  "pepito", email "pepe@gmail.com",contrasenia "0000"));

            usuarioServicio.crearUsuario(usuarioDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
