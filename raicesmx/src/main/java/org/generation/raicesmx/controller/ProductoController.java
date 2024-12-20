package org.generation.raicesmx.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import org.generation.raicesmx.exception.ProductoNotFoundException;
import org.generation.raicesmx.model.ProductoEntity;
import org.generation.raicesmx.service.ProductoService;
import org.generation.raicesmx.service.dto.ProductoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/producto")
@CrossOrigin(origins="*")
public class ProductoController {

	private final ProductoService productoService;
	
	@Autowired
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping("/getall")
	public List<ProductoEntity> getAllProducto(){
		return this.productoService.getAllProductos();
	}
	
	@GetMapping("/get/{id}")
	public ProductoEntity getProducto(@PathVariable("id") Long id) {
		return this.productoService.getProducto(id);
	}
	
	@PostMapping("/new-producto")
	public ResponseEntity<ProductoEntity> createProducto(@RequestBody ProductoDto dto){
//		if(this.productoService.getProducto(newProducto.getId_producto()) != null) {
//			return new ResponseEntity<>(HttpStatus.CONFLICT);
//		}
		return ResponseEntity.status(HttpStatus.CREATED).body(this.productoService.createProducto(dto));
	}
	
	@DeleteMapping("/delete/{id_producto}")
    public void deleteProducto(@PathVariable("id_producto") Long id_producto){
        productoService.deleteProducto(id_producto);
    }
	
	@PutMapping("/update/{id}")
    public ResponseEntity<?> updateProducto(@RequestBody ProductoEntity ProductoEntity, @PathVariable("id") Long id) {

		try {
			return ResponseEntity.ok(this.productoService.updateProducto(ProductoEntity, id));
		} catch (ProductoNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		
		/*ProductoEntity producto = productoService.getProducto(id);

        // Si el artesano no existe mandar mensaje de error
        if (producto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Retorna un 404 si no se encuentra el artesano
        } else { // De lo contrario actualiza los datos del artesano
            producto.setId_producto(ProductoEntity.getId_producto());
            producto.setImagen_url(ProductoEntity.getImagen_url());
            producto.setNombre(ProductoEntity.getNombre());
            producto.setPrecio(ProductoEntity.getPrecio());
            producto.setStock(ProductoEntity.getStock());
            producto.setCategorias_idCategorias(ProductoEntity.getCategorias_idCategorias());
            producto.setStatus(ProductoEntity.getStatus());
            producto.setDescripcion(ProductoEntity.getDescripcion());
            producto.setArtesano_idArtesano(ProductoEntity.getArtesano_idArtesano());

        // Guardar al artesano 
        ProductoEntity updateProducto = productoService.updateProducto(producto);

        // Retornar al artesano actualizado
        return new ResponseEntity<>(updateProducto, HttpStatus.OK);
        }*/
	}
}
