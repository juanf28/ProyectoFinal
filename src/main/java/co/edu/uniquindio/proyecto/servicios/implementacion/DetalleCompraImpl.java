package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.proyecto.dto.EmailDTO;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.DetalleCompraServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DetalleCompraImpl implements DetalleCompraServicio {

    private final DetalleCompraRepo detalleCompraRepo;
    private final ProductoRepo productoRepo;
    @Autowired
    private final EmailServicio emailServicio;

    private final ProductoServicio productoServicio;


    @Override
    public DetalleCompra crearDetalleCompra(DetalleCompraDTO detalleCompraDTO, Compra compra) throws Exception {

        DetalleCompra detalleCompra = new DetalleCompra();

        Producto producto = productoServicio.obtener(detalleCompraDTO.getCodigoProducto());


        int unidades = detalleCompraDTO.getUnidades();

        if(producto.getUnidades()<unidades){
            throw new Exception("No existen las suficientes unidades del producto " + producto.getNombre());
        }
        detalleCompra.setCompra(compra);
        detalleCompra.setProducto(producto);
        detalleCompra.setUnidades(unidades);
        detalleCompra.setValorTotal(calcularTotal(producto,unidades));

        detalleCompraRepo.save(detalleCompra);
        String destinario=producto.getVendedor().getEmail();
        emailServicio.enviarEmail(new EmailDTO("Transaccion realizada","Ha vendido " + unidades + " unidades de su producto " + producto.getNombre() , destinario));

        actualizarUnidades(producto,unidades);

        return detalleCompra;

    }

    @Override
    public void actualizarUnidades(Producto producto, int unidadess){

        int unidades = producto.getUnidades();
        int unidadesAux= unidades-unidadess;

        producto.setUnidades(unidadesAux);

        productoRepo.save(producto);

    }
    private float calcularTotal(Producto producto, int unidades) {

        float total = producto.getPrecio()*unidades;

        return total;
    }

    @Override
    public DetalleCompraGetDTO obtenerDetalleCompra(int codigoDetalleCompra) throws Exception {


        return null;
    }

    @Override
    public List<DetalleCompraGetDTO> listarProductosUsuario(int codigoUsuario) {
        return null;
    }

    @Override
    public List<Integer> obtenerDetallesCodigo(List<DetalleCompra> compras) {
        return null;
    }
}
