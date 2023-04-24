package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private CompraRepo compraRepo;

    @Autowired
    private DetalleCompraRepo detalleCompraRepo;

    @Override
    public Compra crearCompra(CompraDTO compraDTO) {

        Usuario usuario = usuarioRepo.findById(compraDTO.getCedulaUsuario()).orElse(null);

        List<DetalleCompra> listaDetalles = new ArrayList<>();
        Compra compra;
        double totalCompra = 0.0;
        if (usuario == null) {
            try {
                throw new Exception("El Usuario no existe.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


        for (int i = 0; i < compraDTO.getDetalleCompraDTO().size(); i++) {
            DetalleCompraDTO detalleCompraAux = compraDTO.getDetalleCompraDTO().get(i);
            Producto producto = productoRepo.findById(detalleCompraAux.getCodigoProducto()).orElse(null);
            if (producto == null) {
                try {
                    throw new Exception("El producto " + detalleCompraAux.getCodigoProducto() + "no existe.");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            DetalleCompra detalleAux = new DetalleCompra(detalleCompraAux.getUnidades(), detalleCompraAux.getPrecio(), producto);
            listaDetalles.add(detalleAux);
            totalCompra += detalleCompraAux.getPrecio();
        }

        compra = new Compra(totalCompra, LocalDateTime.now(), compraDTO.getMetodoPago(), usuario);
        compra = compraRepo.save(compra);

        for (DetalleCompra detalle : listaDetalles) {
            detalle.setCompra(compra);
            detalleCompraRepo.save(detalle);
        }
        return compra;
    }

    @Override
    public List<CompraGetDTO> listarCompras(int codigoUsuario) {
        return null;
    }

    @Override
    public CompraGetDTO obtenerCompra(int codigoCompra) {
        return null;
    }


    @Override
    public List<CompraGetDTO> listarComprasUsuario(String cedula) throws Exception {

        List<CompraGetDTO> listaCompraGetDto = new ArrayList<>();
        Usuario usuario = usuarioRepo.findById(Integer.valueOf(cedula)).orElse(null);
        compraRepo.listarComprasUsuario(cedula);
        if (usuario == null) {
            throw new Exception("El Usuario no existe.");
        }
        return listaCompraGetDto;
    }
}

