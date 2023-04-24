package co.edu.uniquindio.proyecto.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Estado {

    @Id
    private Integer codigo;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "estado")
    private List<ProductoModerador> moderadores;




}
