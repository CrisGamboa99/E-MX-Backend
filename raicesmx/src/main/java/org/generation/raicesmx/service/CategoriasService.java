package org.generation.raicesmx.service;

import java.util.List;
import java.util.Optional;

import org.generation.raicesmx.exception.CategoriaNotFoundException;
import org.generation.raicesmx.model.CategoriasEntity;
import org.generation.raicesmx.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriasService {
    private final CategoriasRepository categoriasRepository; 
    @Autowired
	public CategoriasService(CategoriasRepository categoriasRepository) {
		this.categoriasRepository = categoriasRepository;
	}
    
    public List<CategoriasEntity> getAllCategorias(){
    	return this.categoriasRepository.findAll();
    }
    
    // Mostrar un registro por id
    public CategoriasEntity getCategoria(Long id_categorias) {
    	return categoriasRepository.findById(id_categorias)
    			.orElseThrow(() -> new CategoriaNotFoundException(id_categorias));
    }
    
    // Mostrar por nombre
    public CategoriasEntity findByNombreCategoria(String nombre) {
    	return this.categoriasRepository.findByNombreCategoria(nombre);
    }
    
    public CategoriasEntity createCategoria(CategoriasEntity newCategoria) {
    	return this.categoriasRepository.save(newCategoria);
    	
    }
    
    // Eliminar un registro por id
    public void deleteCategoria(Long id ) {
    	if(this.categoriasRepository.existsById(id)) {
    		categoriasRepository.deleteById(id);
    	}else {
    		throw new CategoriaNotFoundException(id);
    	}
    	
    }
    
    public CategoriasEntity updateCategoria(CategoriasEntity categoriasModelo, Long id) {
        Optional < CategoriasEntity > categoriasDb = this.categoriasRepository.findById(categoriasModelo.getId_categorias());

        if (categoriasDb.isPresent()) {
            CategoriasEntity categoriasUpdate = categoriasDb.get();
            categoriasUpdate.setNombre_categoria(categoriasModelo.getNombre_categoria());
            categoriasRepository.save(categoriasUpdate);
            return categoriasUpdate;
        } else {
        	throw new CategoriaNotFoundException(id);
        }
    } 
    
    
}
