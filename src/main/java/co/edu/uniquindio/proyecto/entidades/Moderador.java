package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

public class Moderador extends Usuario {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 15, nullable = false)
    private int codigo;

}
