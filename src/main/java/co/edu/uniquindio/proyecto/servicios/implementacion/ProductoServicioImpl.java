package co.edu.uniquindio.proyecto.servicios.implementacion;


import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Estado;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;

    private final UsuarioServicio usuarioServicio;

    UsuarioRepo usuarioRepo;


    public ProductoServicioImpl(ProductoRepo productoRepo, UsuarioServicio usuarioServicio){
        this.productoRepo=productoRepo;
        this.usuarioServicio=usuarioServicio;
    }

   public int contarProductosCategoria(Categoria categoria)throws Exception {

        return productoRepo.obtenerCantidadPorCategoria(categoria);
    }


    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {

        Producto producto = new Producto();
        producto.setNombre( productoDTO.getNombre() );
        producto.setDescripcion( productoDTO.getDescripcion() );
        producto.setUnidades( productoDTO.getUnidades() );
        producto.setPrecio( productoDTO.getPrecio() );
        producto.setCategorias(productoDTO.getCategorias());
        producto.setVendedor(usuarioServicio.obtener(productoDTO.getCodigoVendedor()));
        producto.setFechaCreacion( LocalDateTime.now() );
        producto.setFechaLimite(LocalDateTime.now().plusDays(60));
        return productoRepo.save( producto ).getCodigo();

    }

    @Override
    public ProductoGetDTO actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception {

        validarExiste(codigoProducto);

        Producto producto = convertir (productoDTO);
        producto.setCodigo(codigoProducto);

        return convertir(productoRepo.save(producto));
    }

    public int actualizarUnidades(int codigoProducto, int unidades) throws Exception{

        Producto producto = obtener(codigoProducto);

        producto.setUnidades(unidades);

       return  productoRepo.save(producto).getCodigo();
    }



    public int actualizarEstado(int codigoProducto, Estado estado) throws Exception{

        Producto producto = obtener(codigoProducto);
        producto.setEstado(estado);
        return productoRepo.save(producto).getCodigo();
    }


    @Override
    public int eliminarProducto(int codigoProducto) throws Exception {

        validarExiste(codigoProducto);

        productoRepo.findById(codigoProducto);
        return codigoProducto;
    }

    @Override
    public Producto obtener(int codigoProducto) throws Exception{
        Optional<Producto> producto = productoRepo.findById(codigoProducto);

        if(producto.isEmpty() ){
            throw new Exception("El producto "+codigoProducto+" no está asociado a ningún producto");
        }

        return producto.get();
    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception {

        return convertir(obtener(codigoProducto) );
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario) throws Exception {

        List<Producto> lista = productoRepo.listarProductosUsuario(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    private Producto convertir(ProductoDTO productoDTO){

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setCategorias(productoDTO.getCategorias());
        producto.setCodigo(productoDTO.getCodigo());
        producto.setImagenes(productoDTO.getImagenes());
        producto.setCodigo(productoDTO.getCodigo());
        producto.setEstado(productoDTO.getEstado());
        return producto;
    }

    private ProductoGetDTO convertir(Producto producto){

        ProductoGetDTO productoGetDTO = new ProductoGetDTO(
               producto.getCodigo(),
                producto.getEstado(),
                producto.getFechaLimite(),
                producto.getFechaCreacion(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getUnidades(),
                producto.getVendedor().getCedula(),
                producto.getImagenes(),
                producto.getCategorias(),
                producto.getVendedor()

        );

        return productoGetDTO;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria) throws Exception {
        List<Producto> lista = productoRepo.listarProductosCategoria(categoria);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : lista){
            respuesta.add(convertir(p));
        }
        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPorEstado(Estado estado) throws Exception {
        List<Producto> lista = productoRepo.listarProductosPorEstado(estado);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : lista){
            respuesta.add(convertir(p));
        }
        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario) throws Exception {
        List<Producto> lista = productoRepo.listarProductosFavoritos(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();
        for (Producto p : lista){

            respuesta.add(convertir(p));
        }
        return respuesta;
    }


    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombre) throws Exception {
        List<Producto> lista = productoRepo.listarProductosNombre(nombre);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for (Producto p : lista) {
            respuesta.add(convertir(p));
        }
        return respuesta;
    }


    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo) throws Exception {
        List<Producto> lista = productoRepo.listarProductosPrecio(precioMinimo, precioMaximo);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p: lista){
            respuesta.add(convertir(p));
        }
        return respuesta;
    }

    private void validarProducto(int codigoProducto)throws Exception {

        Optional<Producto> producto = productoRepo.findById(codigoProducto);

        if (producto.isPresent()) {
            throw new Exception("El usuario con el codigo " + codigoProducto+ "no existe");
        }
    }
    private void validarExiste(int codigoProducto) throws Exception {
        boolean existe = productoRepo.existsById(codigoProducto);

        if (!existe) {
            throw new Exception("El código " + codigoProducto + " no está asociado a ningún producto");
        }
    }

    @Override
    public void guardarFavorito(int codigoProducto, int codigoUsuario) throws Exception {
        Usuario usuarioEncontrado=usuarioServicio.obtener(codigoUsuario);
        Producto productoEncontrado= productoRepo.obtenerProducto(codigoProducto);

        if(usuarioEncontrado != null && productoEncontrado != null) {
          //  usuarioEncontrado.getFavoritos().add();

            usuarioRepo.save(usuarioEncontrado);
        }else{
            throw new Exception("El usuario y/o producto no existen");
        }
    }

    @Override
    public void eliminarFavorito(int codigoProducto, int codigoUsuario) throws Exception {
        Usuario usuarioEncontrado=usuarioServicio.obtener(codigoUsuario);
        Producto productoEncontrado= productoRepo.obtenerProducto(codigoProducto);

        if(usuarioEncontrado != null && productoEncontrado != null) {
            usuarioEncontrado.getFavoritos().remove(productoEncontrado);
            usuarioRepo.save(usuarioEncontrado);
        }else{
            throw new Exception("El usuario y/o producto no existen");
        }
    }


    @Override
    public List<Categoria> listarCategorias() throws Exception {
        //System.out.println("categorias"+Arrays.asList(Categoria.values()).toString());
        return new ArrayList<>(Arrays.asList(Categoria.values()));

    }



}
