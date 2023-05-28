package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.DenunciarProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DenunciarRepo extends JpaRepository<DenunciarProducto,Integer> {

    @Query("select De from DenunciarProducto De where De.producto.codigo = :codigoProducto")
    List<DenunciarProducto> listarDenuncias(int codigoProducto);
}
