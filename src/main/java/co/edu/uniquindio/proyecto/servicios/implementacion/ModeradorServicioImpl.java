package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ModeradorDTO;
import co.edu.uniquindio.proyecto.dto.ModeradorGetDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio {
    private ModeradorRepo moderadorRepo;


    @Override
    public int crearModerador(ModeradorDTO moderadorDTO)throws Exception {


        Moderador buscado = moderadorRepo.buscarModerador(moderadorDTO.getCorreo());

        Moderador moderador = new Moderador();

        if (buscado != null){
            throw new Exception(("El correo "+ moderadorDTO.getCorreo() +"ya existe"));
        }

        moderador.setCodigo(moderadorDTO.getCodigo());
        moderador.setCorreo(moderadorDTO.getCorreo());



        return moderadorRepo.save(moderador).getCedula();
    }


    @Override
    public Moderador obtener(int codigoModerador) throws Exception {
        Optional<Moderador> moderador = moderadorRepo.findById(codigoModerador);

        if(moderador.isEmpty() ){
            throw new Exception("El código "+codigoModerador+" no está asociado a ningún usuario");
        }

        return moderador.get();
    }

    @Override
    public ModeradorGetDTO obtenerModerador(int codigoModerador) throws Exception {
        return convertir(obtener(codigoModerador));
    }

    private void validarExiste(int codigoModerador) throws Exception {
        boolean existe = moderadorRepo.existsById(codigoModerador);

        if (!existe) {
            throw new Exception("El código " + codigoModerador + " no está asociado a ningún moderador");
        }
    }

    private ModeradorGetDTO convertir(Moderador moderador){

        ModeradorGetDTO moderadorGetDTO = new ModeradorGetDTO(
                moderador.getCedula(),
                moderador.getEmail());
        return moderadorGetDTO;
    }
}
