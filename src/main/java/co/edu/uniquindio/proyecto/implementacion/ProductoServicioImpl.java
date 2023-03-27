package co.edu.uniquindio.proyecto.implementacion;


import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;

    public ProductoServicioImpl(ProductoRepo productoRepo){
        this.productoRepo=productoRepo;
    }

    @Override
    public int crearProducto(ProductoDTO productoDTO) {
        return 0;
    }

    @Override
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) {
        return 0;
    }

    @Override
    public int eliminarProducto(int codigoProducto) {
        return 0;
    }

    @Override
    public ProductoDTO obtenerProducto(int codigoProducto) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario) {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public List<ProductoDTO> listarProductosPorEstado() {
        return null;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario) {
        return null;
    }

    @Override
    public List<ProductoDTO> listarProductosNombre(String nombre) {
        return null;
    }

    @Override
    public List<ProductoDTO> listarProductosPrecio(float precioMinimo, float precioMaximo) {
        return null;
    }
}
