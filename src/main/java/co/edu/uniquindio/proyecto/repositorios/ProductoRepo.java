package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Estado;
import co.edu.uniquindio.proyecto.entidades.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,Integer> {

    @Query("select p from Producto p where p.vendedor.codigo = :codigoUsuario")
    List<Producto> listarProductosUsuario(int codigoUsuario);

    @Query("select p from Producto p where p.nombre like concat('%', :nombre, '%') = :nombre and p.estado = ACTIVO")
    List<Producto> listarProductosNombre(String nombre);

    @Query("select p from Producto p where p.categoria like concat('%', :categoria, '%') = :categoria and p.estado = ACTIVO")
    List<Producto> listarProductosCategoria(Categoria categoria);

    @Query("select p from Producto p where p.estado = :ACTIVO")
    List<Producto> listarProductosPorEstado(Estado estado);

    List<Producto> listarProductosFavoritos(int codigoUsuario);

    List<Producto> listarProductosPrecio(float precioMinimo, float precioMaximo);




}
