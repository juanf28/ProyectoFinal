package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Estado;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
@AllArgsConstructor
public class ProductoControlador {

    private final ProductoServicio productoServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO>crearProducto(@RequestBody ProductoDTO productoDTO) throws Exception {

        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO(HttpStatus.CREATED, false, productoServicio.crearProducto(productoDTO)));
    }

    @PutMapping("/actualizar/{codigoProducto}")
    public ResponseEntity<MensajeDTO> actualizarProducto(@PathVariable int codigoProducto, @RequestBody ProductoDTO productoDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, productoServicio.actualizarProducto(codigoProducto, productoDTO)));
    }

    @DeleteMapping("/eliminar/{codigoProducto}")
    public ResponseEntity<MensajeDTO> eliminiarProducto(@PathVariable int codigoProducto) throws Exception{
        productoServicio.eliminarProducto(codigoProducto);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, "Producto eliminado correctamente") );
    }

    @GetMapping("/obtener/{codigoProducto}")
    public ResponseEntity<MensajeDTO> obtenerProducto(@PathVariable int codigoProducto) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, productoServicio.obtenerProducto(codigoProducto)));
    }
    @GetMapping("/contarProducto/{categoria}")
    public ResponseEntity<MensajeDTO> contarProductosCategoria(@PathVariable Categoria Categoria) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false, productoServicio.contarProductosCategoria(Categoria)));
    }

    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO> listarProductos()throws Exception {
        Estado estado= Estado.PROBADO;

        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosPorEstado(estado)));
    }
}
