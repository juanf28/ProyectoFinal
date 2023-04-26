package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra,String> {

    @Query("select c from Compra c where c.codigoUsuario = :codigoUsuario")
    List<Compra> listarCompras(int codigoUsuario);

    @Query("select c from Compra c where c.codigoUsuario = :cedula")
    List<Compra> listarComprasUsuario(String cedula);
}
