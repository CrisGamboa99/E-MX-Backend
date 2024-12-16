package org.generation.raicesmx.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.generation.raicesmx.model.ArtesanoEntity;
import org.generation.raicesmx.repository.ArtesanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtesanoService {
	
	private final ArtesanoRepository artesanoRepository;
	
	@Autowired
	public ArtesanoService (ArtesanoRepository artesanoRepository) {
		this.artesanoRepository = artesanoRepository;
	}
	
	// Mostrar todos los registros de artesano
	public List<ArtesanoEntity> getAllArtesano(){
        return this.artesanoRepository.findAll();
    }

	// Mostrar un registro por id
	public ArtesanoEntity getArtesano(Long id_artesano){
	    return artesanoRepository.findById(id_artesano).orElse(null);
	}
	
	// Crear un nuevo registro
    public ArtesanoEntity createArtesano (ArtesanoEntity newArtesano) {
        return this.artesanoRepository.save(newArtesano);
    }
    
    // Eliminar un registro por id
    public void deleteArtesano(Long id) {
        artesanoRepository.deleteById(id);
    }
    
    // Editar un registro
    public ArtesanoEntity updateArtesano(ArtesanoEntity artesanoEntity) {
        Optional < ArtesanoEntity > artesanoDb = this.artesanoRepository.findById(artesanoEntity.getId_artesano());

        if (artesanoDb.isPresent()) {
            ArtesanoEntity artesanoUpdate = artesanoDb.get();
            artesanoUpdate.setId_artesano(artesanoEntity.getId_artesano());
            artesanoUpdate.setNombre(artesanoEntity.getNombre());
            artesanoUpdate.setApellido( artesanoEntity.getApellido() );
            artesanoUpdate.setEmpresa( artesanoEntity.getEmpresa() );
            artesanoUpdate.setCorreo( artesanoEntity.getCorreo() );
            artesanoUpdate.setPassword( artesanoEntity.getPassword() );
            artesanoUpdate.setDireccion( artesanoEntity.getDireccion() );
            artesanoUpdate.setTelefono( artesanoEntity.getTelefono() );
            artesanoUpdate.setCodigo_postal( artesanoEntity.getCodigo_postal() );
            artesanoUpdate.setEstado( artesanoEntity.getEstado() );
            artesanoUpdate.setTipo_usuario( artesanoEntity.getTipo_usuario() );
            artesanoRepository.save(artesanoUpdate);
            return artesanoUpdate;
        } else {
            throw new NoSuchElementException("No se encontró registro con id : " + artesanoEntity.getId_artesano());
        }
    }

}
