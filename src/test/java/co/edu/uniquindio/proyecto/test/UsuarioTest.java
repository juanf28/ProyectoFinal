package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;

/*
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
*/
@SpringBootTest
@Transactional
public class UsuarioTest {
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void registrar() throws Exception{
        UsuarioDTO usuarioDTO = new UsuarioDTO(1006336782,"Santiago","santiago@email.com","root","calle 19","3165308532");
        int codigo = usuarioServicio.crearUsuario(usuarioDTO);
        Usuario usuario = usuarioServicio.obtener(codigo);

        Assertions.assertEquals("Santiago", usuario.getNombreCompleto());


    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() throws Exception{
        String correo = usuarioServicio.obtener(1006336782).getEmail();
        usuarioServicio.eliminarUsuario(1006336782);

        //Assertions.assertNull(UsuarioRepo.findByEmail(correo).orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        /*
        Usuario usuario = usuarioServicio.obtener(1);

        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getCedula(),usuario.getNombreCompleto(),usuario.getEmail(), usuario.getContrasenia(), usuario.getDireccion(),usuario.getNumTelefono());

        int codigo = usuarioServicio.actualizarUsuario(1,usuarioDTO);

        Usuario actualizado = usuarioServicio.obtenerUsuario(codigo);

        Assertions.assertEquals("calle 20", actualizado.getDireccion());

         */
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        /*

        Usuario usuario = usuarioServicio.obtenerUsuario(1);

        Assertions.assertNotNull(usuario);

         */
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        /*
        List<Usuario> list = usuarioRepo.findAll();
        System.out.println(list);

         */
    }

}
