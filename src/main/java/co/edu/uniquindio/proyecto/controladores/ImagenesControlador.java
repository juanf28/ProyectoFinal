package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.CloudinaryServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RequestMapping("api/imagenes")
@RestController
public class ImagenesControlador {

    public List<String> url;
    private CloudinaryServicio cloudinaryServicio;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile)throws Exception {

        File file=cloudinaryServicio.convertir(multipartFile);
        if(file == null){
            return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO(HttpStatus.CREATED, false, "error al subir la imagen") );
        }
        Map datos = cloudinaryServicio.subirImagen(file,"co/edu/uniquindio/proyecto/%s");
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO(HttpStatus.CREATED, false, datos ) );

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeDTO> eliminarImagen(@PathVariable String id) throws Exception{
        Map respuesta = cloudinaryServicio.eliminarImagen(id);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                respuesta ) );
    }
}
