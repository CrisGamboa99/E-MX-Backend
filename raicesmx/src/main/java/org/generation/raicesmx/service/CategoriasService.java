package org.generation.raicesmx.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    public CategoriasEntity createCategoria(CategoriasEntity newCategoria) {
    	return this.categoriasRepository.save(newCategoria);
    	
    }
    public void deleteCategoria(Long id_categorias ) {
    	this.categoriasRepository.deleteById(id_categorias);
    	
    }
    public CategoriasEntity getCategoria(Long id_categorias) {
    	return categoriasRepository.findById(id_categorias).orElse(null);
    }
    
    public CategoriasEntity updateCategoria(CategoriasEntity categoriasModelo) {
        Optional < CategoriasEntity > categoriasDb = this.categoriasRepository.findById(categoriasModelo.getId_categorias());

        if (categoriasDb.isPresent()) {
            CategoriasEntity categoriasUpdate = categoriasDb.get();
            categoriasUpdate.setId_categorias(categoriasModelo.getId_categorias());
            categoriasUpdate.setNombre_categoria(categoriasModelo.getNombre_categoria());
            categoriasRepository.save(categoriasUpdate);
            return categoriasUpdate;
        } else {
            throw new NoSuchElementException("No se encontró registro con id : " + categoriasModelo.getId_categorias());
        }
    } 
    
    
}
