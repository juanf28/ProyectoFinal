package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {


    private final EmailServicio emailServicio;

    private final UsuarioServicio usuarioServicio;

    @Autowired
    private final CompraRepo compraRepo;

    private final DetalleCompraServicio detalleCompraServicio;

    @Override
    public int crearCompra(CompraDTO compraDTO) throws Exception {

        Compra compra = new Compra();

        compra.setMetodoPago(compraDTO.getMetodoPago());
        Usuario usuario = usuarioServicio.obtener(compraDTO.getCodigoUsuario());
        compra.setCodigoUsuario(usuario.getCedula());
        compra.setFechaCompra(LocalDateTime.now());

        List<DetalleCompra> detalleCompraList = new ArrayList<>();

        float subtotal=0;

        for (DetalleCompraDTO detalleCompraDTO: compraDTO.getDetalleCompraDTO()) {
            DetalleCompra detalleCompra = detalleCompraServicio.crearDetalleCompra(detalleCompraDTO, compra);

            detalleCompraList.add(detalleCompra);
            subtotal+=detalleCompra.getValorTotal();
        }

        compra.setDetalleCompraList(detalleCompraList);
        compra.setValorTotal(subtotal);
        compraRepo.save(compra);

        String cuerpoCorreo= "<p>" + usuario.getNombreCompleto() + " ha hecho un compra por $" + subtotal + " existosamente.</p>";
        cuerpoCorreo+="<h3>Detalles de la compra:</h3>";

        for (DetalleCompra detalleCompra :detalleCompraList) {
            cuerpoCorreo+="<p><b>Producto:</b> " + detalleCompra.getProducto().getNombre() ;
        }
        System.out.println(cuerpoCorreo);

        emailServicio.enviarEmail(new EmailDTO("Compra realizada con exito",cuerpoCorreo, usuario.getEmail()));

        return compra.getCodigo();
    }




    public List<CompraGetDTO> listarComprasUsuario(int codigoUsuario) throws Exception {

        List<CompraGetDTO> lista = compraRepo.listarComprasUsuario(codigoUsuario);


        return lista;
    }
    @Override
    public CompraGetDTO obtenerCompra(int codigoCompra) {

        CompraGetDTO compraGetDTO = compraRepo.obtenerCompra(codigoCompra);

        return compraGetDTO;
    }

    public List<CompraGetDTO> listarCompras(int codigoCompra)throws Exception{
        List<CompraGetDTO> lista = compraRepo.listarCompras(codigoCompra);

        return lista;
    }

    private Compra convertir(CompraDTO compraDTO){

        Compra compra = new Compra();
        compra.setCodigo(compraDTO.getCodigo());
        compra.setCodigoUsuario(compraDTO.getCodigoUsuario());
        compra.setFechaCompra(compraDTO.getFechaCompra());

        return compra;
    }

    private CompraGetDTO convertir(Compra compra){

        CompraGetDTO compraGetDTO = new CompraGetDTO(
                compra.getCodigo(),
                compra.getCodigoUsuario(),
                compra.getMetodoPago(),
                compra.getDetalleCompraList(),
                compra.getFechaCompra(),
                compra.getValorTotal()
        );

        return compraGetDTO;
    }


}

