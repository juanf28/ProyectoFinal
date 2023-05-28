package co.edu.uniquindio.proyecto.controladores;


import co.edu.uniquindio.proyecto.dto.DenunciaProductoDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.DenunciarProductoServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/denunciar")
@RestController
@AllArgsConstructor
public class DenunciaControlador {
    private final DenunciarProductoServicio denunciarProductoServicio;
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearDenuncia(@Valid @RequestBody DenunciaProductoDTO denunciaProductoDTO) throws Exception{
        denunciarProductoServicio.crearDenuncia(denunciaProductoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED, false, "Denuncial asignada correctamente"));
    }
    @GetMapping("/listarCalificacion/{codigoProducto}")
    public ResponseEntity<MensajeDTO> listarCalificacion(@PathVariable int codigoProducto){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, denunciarProductoServicio.listarDenuncias(codigoProducto)));
    }


}
