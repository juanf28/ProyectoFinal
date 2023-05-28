package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.email = :correo")
    Usuario buscarUsuario(String correo);
    @Query("select u from Usuario u where u.cedula = :codigo")
    Usuario obtenerUsuario2(int codigo);

    @Query("select u from Usuario u where u.email = :email and u.password = :password")
    Usuario comprobarAutenticacion(String email, String password);
    @Query("select u from Usuario u where u.email = :email")
    Optional<Usuario> findByEmail(String email);

}
