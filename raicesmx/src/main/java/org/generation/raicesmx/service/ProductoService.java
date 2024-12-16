package org.generation.raicesmx.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
	    return productoRepository.findById(id_producto).orElse(null);
	}

	public ProductoEntity createProducto (ProductoEntity newProducto) {
	    return this.productoRepository.save(newProducto);
	}
    
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
    
 // Editar un producto
    public ProductoEntity updateProducto(ProductoEntity ProductoEntity) {
        Optional < ProductoEntity > productoDb = this.productoRepository.findById(ProductoEntity.getId_producto());

        if (productoDb.isPresent()) {
            ProductoEntity productoUpdate = productoDb.get();
            productoUpdate.setId_producto(ProductoEntity.getId_producto());
            productoUpdate.setImagen_url(ProductoEntity.getImagen_url());
            productoUpdate.setNombre(ProductoEntity.getNombre());
            productoUpdate.setPrecio(ProductoEntity.getPrecio());
            productoUpdate.setStock(ProductoEntity.getStock());
            productoUpdate.setCategorias_idCategorias(ProductoEntity.getCategorias_idCategorias());
            productoUpdate.setStatus(ProductoEntity.getStatus());
            productoUpdate.setDescripcion(ProductoEntity.getDescripcion());
            productoUpdate.setArtesano_idArtesano(ProductoEntity.getArtesano_idArtesano());
            productoRepository.save(productoUpdate);
            return productoUpdate;
        } else {
            throw new NoSuchElementException("No se encontró registro con id: " + ProductoEntity.getId_producto());
        }
    }
}
