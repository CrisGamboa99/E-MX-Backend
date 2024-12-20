	package org.generation.raicesmx.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import org.generation.raicesmx.exception.CategoriaNotFoundException;
import org.generation.raicesmx.model.CategoriasEntity;
import org.generation.raicesmx.service.CategoriasService;
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
@RequestMapping("/api/v1/categorias")
@CrossOrigin(origins="*")
public class CategoriasController {
	private final CategoriasService categoriasService;
	
	@Autowired
	public CategoriasController(CategoriasService categoriasService) {
		this.categoriasService = categoriasService;
	}

	@GetMapping("/getall")
	public List<CategoriasEntity> getCategorias(){
		return this.categoriasService.getAllCategorias();
	}
	
	@GetMapping("/get/{id_categorias}")
	public CategoriasEntity getCategoria(@PathVariable("id_categorias") Long id_categorias) {
		return this.categoriasService.getCategoria(id_categorias);
	}

	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<CategoriasEntity> findByNombreCategoria(@PathVariable(name = "nombre") String nombre){
		if(this.categoriasService.findByNombreCategoria(nombre) == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(this.categoriasService.findByNombreCategoria(nombre));
	}

	@PostMapping("/new-categorias")
	public ResponseEntity<CategoriasEntity> createCategoria(@RequestBody CategoriasEntity newCategoria) {
		if(this.categoriasService.findByNombreCategoria(newCategoria.getNombre_categoria()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(this.categoriasService.createCategoria(newCategoria));
	}

	@DeleteMapping("/delete/{id_categorias}")
	public void deleteCategoria(@PathVariable("id_categorias") Long id_categorias) {
		this.categoriasService.deleteCategoria(id_categorias);
	}

	@PutMapping("/put/{id_categorias}") 
	public ResponseEntity<?> updateCategoria(@RequestBody CategoriasEntity categoriasModelo,@PathVariable("id_categorias") Long id_categorias){
		try {
			return ResponseEntity.ok(this.categoriasService.updateCategoria(categoriasModelo, id_categorias));
		} catch (CategoriaNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	
		/*CategoriasEntity categoria= categoriasService.getCategoria(id_categorias);
		if (categoria==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			categoria.setNombre_categoria(categoriasModelo.getNombre_categoria());
			CategoriasEntity updateCategoria= categoriasService.updateCategoria(categoria);
			return new ResponseEntity<>(updateCategoria,HttpStatus.OK);
		} */
	}
}
