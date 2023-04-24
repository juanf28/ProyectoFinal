package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {
    @Autowired
    private UsuarioRepo usuarioRepo;
    /*
    @Test
    public void registrar(){
        //ArrayList<String> telefonos = new ArrayList<>();
        Usuario usuario= new Usuario("pepito","1006336782","3165308532","pepito@email.com","root","calle 19");
        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        Assertions.assertEquals("pepito", usuarioGuardado.getNombreCompleto());
    }
    */
    public void eliminar(){

    }
    public void actualizar(){

    }
    public void obtener(){

    }
    public void listar(){

    }

}
