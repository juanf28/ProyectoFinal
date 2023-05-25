package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra,Integer> {

    @Query("select c from Compra c where c.codigo = :codigoCompra")
    List<CompraGetDTO> listarCompras(int codigoCompra);

    @Query("select c from Compra c where c.codigoUsuario = :codigoUsuario")
    List<CompraGetDTO> listarComprasUsuario(int codigoUsuario);

    @Query("select c from Compra c where c.codigo = :codigoCompra")
    CompraGetDTO obtenerCompra(int codigoCompra);
}
