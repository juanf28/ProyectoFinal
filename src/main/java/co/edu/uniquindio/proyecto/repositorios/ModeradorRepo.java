package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModeradorRepo extends JpaRepository<Moderador, Integer> {
    @Query("select u from Moderador u where u.email = :correo")
    Moderador buscarModerador(String correo);


    @Query("select u from Moderador u where u.email = :correo and u.cedula = :cedulaModerador")
    Moderador buscarCorreo(String correo, String cedulaModerador);

    Optional<Moderador> findByEmail(String email);
}
