package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.dto.DetalleCompraDTO;
import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

  public interface DetalleCompraRepo extends JpaRepository<DetalleCompra,Integer> {

  @Query("select dc from DetalleCompra dc where dc.codigo = :codigoDetalleCompra")
  List<DetalleCompraDTO> listarDetalleCompra(int codigoDetalleCompra);

}
