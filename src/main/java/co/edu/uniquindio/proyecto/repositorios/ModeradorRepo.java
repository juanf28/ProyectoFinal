package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Moderador;

import java.util.Optional;

public interface ModeradorRepo {
    Optional<Moderador> findByEmail(String email);
}
