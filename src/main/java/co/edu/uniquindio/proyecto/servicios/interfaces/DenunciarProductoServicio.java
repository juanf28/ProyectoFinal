package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.DenunciaProductoDTO;
import co.edu.uniquindio.proyecto.entidades.DenunciarProducto;

import java.util.List;

public interface DenunciarProductoServicio {


    int crearDenuncia(DenunciaProductoDTO denunciaProductoDTO) throws Exception;

    List<DenunciarProducto> listarDenuncias(int codigoProducto);

}
