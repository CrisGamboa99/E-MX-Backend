package org.generation.raicesmx.service;

import java.util.List;
import java.util.Optional;

import org.generation.raicesmx.exception.CategoriaNotFoundException;
import org.generation.raicesmx.exception.PedidoNotFoundException;
import org.generation.raicesmx.exception.ProductoNotFoundException;
import org.generation.raicesmx.exception.StatusNotFoundException;
import org.generation.raicesmx.exception.UserNotFoundException;
import org.generation.raicesmx.model.ArtesanoEntity;
import org.generation.raicesmx.model.CategoriasEntity;
import org.generation.raicesmx.model.PedidoEntity;
import org.generation.raicesmx.model.ProductoEntity;
import org.generation.raicesmx.model.StatusEntity;
import org.generation.raicesmx.repository.ArtesanoRepository;
import org.generation.raicesmx.repository.CategoriasRepository;
import org.generation.raicesmx.repository.PedidoRepository;
import org.generation.raicesmx.repository.ProductoRepository;
import org.generation.raicesmx.repository.StatusRepository;
import org.generation.raicesmx.service.dto.ProductoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

	private final ProductoRepository productoRepository;
	private final ArtesanoRepository artesanoRepository;
	private final CategoriasRepository categoriasRepository;
	private final StatusRepository statusRepository;
	private final PedidoRepository pedidoRepository;
	
	@Autowired
	public ProductoService(ProductoRepository productoRepository, ArtesanoRepository artesanoRepository,
			CategoriasRepository categoriasRepository, StatusRepository statusRepository,
			PedidoRepository pedidoRepository) {
		super();
		this.productoRepository = productoRepository;
		this.artesanoRepository = artesanoRepository;
		this.categoriasRepository = categoriasRepository;
		this.statusRepository = statusRepository;
		this.pedidoRepository = pedidoRepository;
	}

	
	public List<ProductoEntity> getAllProductos(){
	    return this.productoRepository.findAll();
	}

	public ProductoEntity getProducto(Long id_producto){
	    return productoRepository.findById(id_producto)
	    		.orElseThrow(() -> new ProductoNotFoundException(id_producto));
	}

	// Crear un nuevo producto
	public ProductoEntity createProducto (ProductoDto dto) {
	    ArtesanoEntity artesano = this.artesanoRepository.findById(dto.getId_artesano()).orElseThrow(() -> new UserNotFoundException(dto.getId_artesano()));
	    
	    CategoriasEntity categoria = this.categoriasRepository.findById(dto.getId_categorias()).orElseThrow(() -> new CategoriaNotFoundException(dto.getId_categorias()));
	    
	    StatusEntity status = this.statusRepository.findById(dto.getId_status()).orElseThrow(() -> new StatusNotFoundException(dto.getId_status()));
	    
	    PedidoEntity pedido = this.pedidoRepository.findById(dto.getId_pedido()).orElseThrow(() -> new PedidoNotFoundException(dto.getId_pedido()));
	    
	    ProductoEntity producto = new ProductoEntity();
	    
	    producto.setImagen_url(dto.getImagen_url());
	    producto.setNombre(dto.getNombre());
	    producto.setPrecio(dto.getPrecio());
	    producto.setStock(dto.getStock());
	    producto.setDescripcion(dto.getDescripcion());
	    producto.setArtesano(artesano);
	    producto.setCategorias(categoria);
	    producto.setStatus(status);
	    producto.setPedido(pedido);
	    
	    return this.productoRepository.save(producto);
	}
    
	// Eliminar un registro por id
    public void deleteProducto(Long id) {
    	if(this.productoRepository.existsById(id)) {
    		productoRepository.deleteById(id);
    	}else {
    		throw new ProductoNotFoundException(id);
    	}
        
    }
    
 // Editar un producto
    public ProductoEntity updateProducto(ProductoEntity ProductoEntity, Long id) {
        Optional < ProductoEntity > productoDb = this.productoRepository.findById(ProductoEntity.getId_producto());

        if (productoDb.isPresent()) {
            ProductoEntity productoUpdate = productoDb.get();
            productoUpdate.setImagen_url(ProductoEntity.getImagen_url());
            productoUpdate.setNombre(ProductoEntity.getNombre());
            productoUpdate.setPrecio(ProductoEntity.getPrecio());
            productoUpdate.setStock(ProductoEntity.getStock());
           
            productoUpdate.setStatus(ProductoEntity.getStatus());
            productoUpdate.setDescripcion(ProductoEntity.getDescripcion());
            
            productoRepository.save(productoUpdate);
            return productoUpdate;
        } else {
        	throw new ProductoNotFoundException(id);
        }
    }
}
