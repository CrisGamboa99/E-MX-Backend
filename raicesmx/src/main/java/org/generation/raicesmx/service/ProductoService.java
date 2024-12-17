package org.generation.raicesmx.service;

import java.util.List;
import java.util.Optional;

import org.generation.raicesmx.exception.ProductoNotFoundException;
import org.generation.raicesmx.model.ProductoEntity;
import org.generation.raicesmx.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

	private final ProductoRepository productoRepository;
	
	@Autowired
	public ProductoService (ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	public List<ProductoEntity> getAllProductos(){
	    return this.productoRepository.findAll();
	}

	public ProductoEntity getProducto(Long id_producto){
	    return productoRepository.findById(id_producto)
	    		.orElseThrow(() -> new ProductoNotFoundException(id_producto));
	}

	public ProductoEntity createProducto (ProductoEntity newProducto) {
	    return this.productoRepository.save(newProducto);
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
