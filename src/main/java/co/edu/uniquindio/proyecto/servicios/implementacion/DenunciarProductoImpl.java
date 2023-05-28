package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.DenunciaProductoDTO;
import co.edu.uniquindio.proyecto.entidades.DenunciarProducto;
import co.edu.uniquindio.proyecto.repositorios.DenunciarRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.DenunciarProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@AllArgsConstructor
@Service
public class DenunciarProductoImpl implements DenunciarProductoServicio {

    DenunciarRepo denunciarRepo;
    ProductoRepo productoRepo;

    private final UsuarioServicio usuarioServicio;



    @Override
    public int crearDenuncia(DenunciaProductoDTO denunciaProductoDTO) throws Exception {

        DenunciarProducto denunciarProducto = new DenunciarProducto();
        denunciarProducto.setUsuario(usuarioServicio.obtener(denunciaProductoDTO.getCodigoUsuario()));
        denunciarProducto.setMotivoDenuncia(denunciaProductoDTO.getMotivoDenuncia());
        denunciarProducto.setProducto(productoRepo.obtenerProducto(denunciaProductoDTO.getCodigoProducto()));
        return denunciarRepo.save( denunciarProducto ).getCodigo();

    }

    @Override
    public List<DenunciarProducto> listarDenuncias(int codigoProducto) {

        List<DenunciarProducto> lista = denunciarRepo.listarDenuncias(codigoProducto);

        return lista;

    }
}
