package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModeradorRepo extends JpaRepository<Moderador, Integer> {
    @Query("select u from Moderador u where u.email = :correo")
    Moderador buscarModerador(String correo);


    @Query("select u from Moderador u where u.email = :correo and u.cedula = :cedulaModerador")
    Moderador buscarCorreo(String correo, String cedulaModerador);

    @Query("select m from Moderador m where m.email = :email")
    Optional<Moderador> findByEmail(String email);
    @Query("select p from Producto p join ProductoModerador pm on p.codigo = pm.producto.codigo where pm.producto.codigo = :codigoProducto")
    List<ProductoGetDTO> listarProductos(int codigoProducto);
    @Query("select p from Producto p where p.codigo = :codigoProducto")
    Producto revisarProducto (int codigoProducto);

}
