package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Estado;

import java.util.List;

public interface ProductoServicio {
   int crearProducto(ProductoDTO productoDTO)throws Exception;

   ProductoGetDTO actualizarProducto(int codigoProducto,ProductoDTO productoDTO)throws Exception;

   int actualizarUnidades(int codigoProducto, int unidades) throws Exception;

   int actualizarEstado(int codigoProducto, Estado estado) throws Exception;

   int eliminarProducto(int codigoProducto)throws Exception;

   ProductoGetDTO obtenerProducto(int codigoProducto)throws Exception;

   List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario)throws Exception;

   List<ProductoGetDTO> listarProductosCategoria(Categoria categoria)throws Exception;

   List<ProductoGetDTO> listarProductosPorEstado()throws Exception;

   List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario)throws Exception;

   List<ProductoGetDTO> listarProductosNombre(String nombre)throws Exception;

   List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo)throws Exception;

}
