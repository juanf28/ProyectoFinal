package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Estado;
import co.edu.uniquindio.proyecto.entidades.MetodoPago;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
@AllArgsConstructor
public class ProductoControlador {

    private final ProductoServicio productoServicio;

    private final UsuarioServicio usuarioServicio;

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
        Estado estado= Estado.NO_REVISADO;
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosPorEstado(estado)));
    }

    @GetMapping("/listarProductosCategoria/{categoria}")
    public ResponseEntity<MensajeDTO> listarProductosCategoria(@PathVariable Categoria categoria) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosCategoria(categoria)));
    }
    @GetMapping("/listarProductosEstado/{estado}")
    public ResponseEntity<MensajeDTO> listarProductosEstado(@PathVariable Estado estado)throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosPorEstado(estado)));
    }
    @GetMapping("misproductos/{correoUsuario}")
    public ResponseEntity<MensajeDTO> listarProductosUsuario(@PathVariable int codigoUsuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,false, productoServicio.listarProductosUsuario(codigoUsuario)));
    }
    @GetMapping("/listarProductosFavoritos/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> listarProductosFavoritos(@PathVariable int codigoUsuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosFavoritos(codigoUsuario)));
    }
    @GetMapping("/listarProductosPrecio/{precioMinimo}/{precioMaximo}")
    public ResponseEntity<MensajeDTO> listarProductosPrecio(@PathVariable float precioMinimo,@PathVariable float precioMaximo) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosPrecio(precioMinimo,precioMaximo)));
    }
    @GetMapping("/listarProductosNombre/{nombre}")
    public ResponseEntity<MensajeDTO> listarProductosNombre(@PathVariable String nombre) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.listarProductosNombre(nombre)));
    }
    @PostMapping("/guardarFavorito/{codigoProducto}/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> guardarFavorito(@PathVariable int codigoProducto,@PathVariable int codigoUsuario) throws Exception{
        productoServicio.guardarFavorito(codigoProducto, codigoUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Producto guardado en favoritos"));
    }
    @DeleteMapping("/eliminarFavorito/{codigoProducto}/{codigoUsuario}")
    public ResponseEntity<MensajeDTO> eliminarFavorito(@PathVariable int codigoProducto,@PathVariable int codigoUsuario) throws Exception {
        productoServicio.eliminarFavorito(codigoProducto, codigoUsuario);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, "Producto eliminado de favoritos"));
    }

    @GetMapping("/mediopago")
    public ResponseEntity<MetodoPago[]> getMedioPago() {
        return ResponseEntity.status(HttpStatus.OK).body( MetodoPago.values());
    }

}
