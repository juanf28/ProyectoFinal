package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;

import java.util.List;

public interface ProductoServicio {
   int crearProducto(ProductoDTO productoDTO)throws Exception;

   int actualizarProducto(int codigoProducto,ProductoDTO productoDTO);

   int eliminarProducto(int codigoProducto);

   ProductoDTO obtenerProducto(int codigoProducto);

   List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario);

   List<ProductoGetDTO> listarProductosCategoria(Categoria categoria);

   List<ProductoDTO> listarProductosPorEstado();

   List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario);

   List<ProductoDTO> listarProductosNombre(String nombre);

   List<ProductoDTO> listarProductosPrecio(float precioMinimo, float precioMaximo);

}
