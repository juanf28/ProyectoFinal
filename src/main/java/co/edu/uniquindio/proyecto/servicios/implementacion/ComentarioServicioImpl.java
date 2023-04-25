package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioGetDTO;
import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.exception.ListaVaciaException;
import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepo comentarioRepo;
    private final UsuarioServicio usuarioServicio;
    private final ProductoServicio productoServicio;

    private EmailServicio EmailServicio;

    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {

        Producto producto = productoServicio.obtener(comentarioDTO.getCodigoProducto()); //se guarda el producto

        Comentario comentario = new Comentario();
        comentario.setMensaje(comentarioDTO.getMensaje());
        comentario.setFechaCreacion(LocalDateTime.now());
        comentario.setProducto(producto); //se asigna el producto guardado
        comentario.setUsuario(usuarioServicio.obtener(comentarioDTO.getCodigoUsuario()));

        //se debe enviar un email (al usuario que publicó el producto) con lo que escribió la persona.
        String emailVendedor = producto.getModerador().getEmail();
        EmailServicio.enviarEmail(new EmailDTO(
                "Nuevo comentario",
                comentarioDTO.getMensaje(),
                emailVendedor));

        return comentarioRepo.save(comentario).getCodigo();
    }


    @Override
    public List<ComentarioGetDTO> listarComentarios(int codigoProducto) {
        List<Comentario> lista = comentarioRepo.listaComentarios(codigoProducto);

        if(lista.isEmpty()){
            try {
                throw new ListaVaciaException("Producto sin comentarios");
            } catch (ListaVaciaException e) {
                throw new RuntimeException(e);
            }
        }

        List<ComentarioGetDTO> respuesta = new ArrayList<>();

        for (Comentario c : lista){
            respuesta.add(convertir(c));
        }

        return respuesta;
    }

    private ComentarioGetDTO convertir(Comentario comentario) {
        return new ComentarioGetDTO(
                comentario.getCodigo(),
                comentario.getFechaCreacion(),
                comentario.getMensaje(),
                comentario.getUsuario().getCedula(),
                comentario.getProducto().getCodigo()
        );
    }

}