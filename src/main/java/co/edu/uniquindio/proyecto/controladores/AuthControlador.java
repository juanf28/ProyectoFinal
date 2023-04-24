package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.servicios.interfaces.SesionServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthControlador {

    private final UsuarioServicio clienteServicio;
    private final SesionServicio sesionServicio;

}
