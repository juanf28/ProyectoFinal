package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.entidades.ProductoModerador;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class ProductoTest {
    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
    private ProductoModerador productoModerador;
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    public void registrar() throws Exception{
        UsuarioDTO usuarioDTO = new UsuarioDTO(1006336782,"Santiago","santiago@email.com","root","calle 19","3165308532");
        int codigo = usuarioServicio.crearUsuario(usuarioDTO);
        Usuario usuario = usuarioServicio.obtener(codigo);
        ProductoDTO productoDTO = new ProductoDTO("Audifonos",01,"De cable",2,20000,01,);
    }
}
