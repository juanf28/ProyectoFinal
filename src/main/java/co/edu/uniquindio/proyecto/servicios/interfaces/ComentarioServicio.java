package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;

import java.util.List;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentarioDTO) throws Exception;

    ComentarioGetDTO actualizarComentario(int codigoComentario, ComentarioDTO comentarioDTO)throws Exception;

    int eliminiarComentario(int codigoComentario)throws Exception;

    ComentarioGetDTO obtenerComentario(int codigoComentario)throws Exception;
  //  Comentario obtener(int codigoComentario)throws Exception;

    List<ComentarioGetDTO> listarComentarios(int codigoProducto);

}