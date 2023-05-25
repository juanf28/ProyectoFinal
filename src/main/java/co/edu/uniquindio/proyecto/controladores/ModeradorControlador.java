package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.ModeradorDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.entidades.Estado;
import co.edu.uniquindio.proyecto.servicios.interfaces.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/moderador")
@RestController
@AllArgsConstructor
public class ModeradorControlador {

    private final ModeradorServicio moderadorServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearModerador(@RequestBody ModeradorDTO moderadorDTO)  throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO(HttpStatus.CREATED, false, moderadorServicio.crearModerador(moderadorDTO)) );
    }

    @GetMapping("/listarProducto/{estado}")
    public ResponseEntity<MensajeDTO> listarProductos(@PathVariable Estado estado) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, moderadorServicio.listarProductos(estado)));
    }
    @PutMapping("/revisarProducto/{codigoProducto}")
    public ResponseEntity<MensajeDTO> revisarProducto (@PathVariable int codigoProducto) throws Exception {
        moderadorServicio.revisarProducto(codigoProducto);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Estado del producto revisado"));
    }



}
