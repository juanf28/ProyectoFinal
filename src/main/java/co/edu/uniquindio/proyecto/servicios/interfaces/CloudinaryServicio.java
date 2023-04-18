package co.edu.uniquindio.proyecto.servicios.interfaces;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface CloudinaryServicio {

    Map subirImagen(File file, String carpeta) throws Exception;
    Map eliminarImagen(String idImagen) throws Exception;
    File convertir(MultipartFile imagen) throws IOException;

}
