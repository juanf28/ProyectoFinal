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
    public void eliminar(){

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){

    }

}
