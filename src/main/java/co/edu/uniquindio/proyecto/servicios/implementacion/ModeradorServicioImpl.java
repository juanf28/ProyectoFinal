package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.entidades.Estado;
import co.edu.uniquindio.proyecto.entidades.Moderador;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.ModeradorRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModeradorServicioImpl implements ModeradorServicio {
    private ModeradorRepo moderadorRepo;

    private final ProductoRepo productoRepo;


    @Autowired
    private final ProductoServicio productoServicio;


    @Override
    public int crearModerador(ModeradorDTO moderadorDTO)throws Exception {


        Moderador buscado = moderadorRepo.buscarModerador(moderadorDTO.getCorreo());

        Moderador moderador = new Moderador();

        if (buscado != null){
            throw new Exception(("El correo "+ moderadorDTO.getCorreo() +"ya existe"));
        }

        moderador.setCedula(moderadorDTO.getCodigo());
        moderador.setEmail(moderadorDTO.getCorreo());



        return moderadorRepo.save(moderador).getCedula();
    }


    @Override
    public Moderador obtener(int codigoModerador) throws Exception {
        Optional<Moderador> moderador = moderadorRepo.findById(codigoModerador);

        if(moderador.isEmpty() ){
            throw new Exception("El código "+codigoModerador+" no está asociado a ningún Moderador");
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
        ModeradorGetDTO moderadorGetDTO = new ModeradorGetDTO(moderador.getCedula(),moderador.getNombreCompleto(),moderador.getPassword(), moderador.getEmail());
        return moderadorGetDTO;
    }

    @Override
    public List<ProductoGetDTO> listarProductos(Estado estado) throws Exception {
        List<ProductoGetDTO> lista = productoServicio.listarProductosPorEstado(estado);
        return lista;
    }
    @Override
    public void revisarProducto(int codigoProducto) throws Exception {

        Producto producto = moderadorRepo.revisarProducto(codigoProducto);

        System.out.println("Producto: "+producto.getNombre()+"Precio"+producto.getPrecio());
    }

    @Override
    public void cambiarEstado(Estado estado, int codigoProducto) throws Exception {

        Producto producto = productoServicio.obtener(codigoProducto);
        producto.setEstado(estado);

        (productoRepo.save(producto)).getCodigo();

    }
}
