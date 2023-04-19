package co.edu.uniquindio.proyecto.servicios.implementacion;
import java.util.Optional;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;;


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
    public Compra crearCompra(CompraDTO compraDTO) throws Exception {

        Optional<Usuario> usuario = usuarioRepo.findById(compraDTO.getCodigoUsuario());
        if (!usuario.isPresent()) {
            throw new Exception("El Usuario no existe.");
        }

        List<DetalleCompra> listaDetalles = new ArrayList<DetalleCompra>();
        Compra compra = new Compra();
        Double totalCompra = 0.0;
        if (compraDTO.getDetalleCompraDTO().isEmpty()) {
            throw new Exception("La lista de detalles de compra está vacía.");
        }

        for (int i = 0; i < compraDTO.getDetalleCompraDTO().size(); i++) {
            DetalleCompraDTO detalleCompraAux = compraDTO.getDetalleCompraDTO().get(i);
            Producto producto = productoRepo.findById(detalleCompraAux.getCodigoProducto()).orElse(null);
            if (producto == null) {
                throw new Exception("El producto " + detalleCompraAux.getCodigoProducto() + " no existe.");
            }
            DetalleCompra detalleCompra = new DetalleCompra();
            detalleCompra.setCodigoCompra(producto.getCodigo());
            detalleCompra.setPrecioProducto(detalleCompraAux.getPrecio());
            detalleCompra.setUnidades(detalleCompraAux.getUnidades());
            //DetalleCompra detalleAux = new DetalleCompra(detalleCompraAux.getUnidades(), detalleCompraAux.getPrecio(), producto.getNombre());
            DetalleCompra detalleAux = detalleCompra;
            listaDetalles.add(detalleAux);
            totalCompra += detalleCompraAux.getPrecio();
        }

        if(usuario.isPresent()) {
            compra.setValorTotal(totalCompra.floatValue());
            compra.setFechaCompra(LocalDate.now());
            compra.setIdMetodoPago(compraDTO.getMetodoPago().getDescripcion());
            compra.setCodigoUsuario(usuario.get().getCedula());

            compra = compraRepo.save(compra);
        } else {
            // Manejar el caso en que usuario no está presente
        }



        for (DetalleCompra detalle : listaDetalles) {
            detalle.setCodigoCompra(compra.getId());
            detalleCompraRepo.save(detalle);
        }

        return compra;
    }


    @Override
    public CompraGetDTO obtenerCompra(int codigoCompra) throws Exception {
        return null;
    }


    @Override
    public List<CompraGetDTO> listarCompras(int codigoUsuario) throws Exception {

        List<CompraGetDTO> listaCompraGetDto = new ArrayList<CompraGetDTO>();
       // Usuario usuario = usuarioRepo.findById(codigoUsuario).orElse(null);

        //Usuario usuario = usuarioRepo.
        List<Compra> listaCompras = compraRepo.listarCompras(codigoUsuario);

        return listaCompraGetDto;
    }

    public CompraGetDTO obtenerCompra (CompraGetDTO compraGetDTO) throws Exception {


        return compraGetDTO;
    }
}

