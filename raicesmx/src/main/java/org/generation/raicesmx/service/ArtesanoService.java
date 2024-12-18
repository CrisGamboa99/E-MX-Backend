package org.generation.raicesmx.service;

import java.util.List;
import java.util.Optional;
import org.generation.raicesmx.exception.UserNotFoundException;
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
	    return this.artesanoRepository.findById(id_artesano)
	    		.orElseThrow(() -> new UserNotFoundException(id_artesano));
	}
	
	// Mostrar por correo
	public ArtesanoEntity findByEmail(String correo) {
		return this.artesanoRepository.findByEmail(correo);
	}
	
	// Crear un nuevo registro
    public ArtesanoEntity createArtesano (ArtesanoEntity newArtesano) {
        return this.artesanoRepository.save(newArtesano);
    }
    
    // Eliminar un registro por id
    public void deleteArtesano(Long id) {
    	if(this.artesanoRepository.existsById(id)) {
    		artesanoRepository.deleteById(id);
    	}else {
    		throw new UserNotFoundException(id);
    	}
        
    }
    
    // Editar un registro
    public ArtesanoEntity updateArtesano(ArtesanoEntity artesanoEntity, Long id) {
        Optional < ArtesanoEntity > artesanoDb = this.artesanoRepository.findById(artesanoEntity.getId_artesano());

        if (artesanoDb.isPresent()) {
            ArtesanoEntity artesanoUpdate = artesanoDb.get();
            artesanoUpdate.setNombre(artesanoEntity.getNombre());
            artesanoUpdate.setApellido( artesanoEntity.getApellido() );
            artesanoUpdate.setEmpresa( artesanoEntity.getEmpresa() );
            artesanoUpdate.setCorreo( artesanoEntity.getCorreo() );
            artesanoUpdate.setPassword( artesanoEntity.getPassword() );
            artesanoUpdate.setDireccion( artesanoEntity.getDireccion() );
            artesanoUpdate.setTelefono( artesanoEntity.getTelefono() );
            artesanoUpdate.setCodigo_postal( artesanoEntity.getCodigo_postal() );
            artesanoUpdate.setEstado( artesanoEntity.getEstado() );
            artesanoRepository.save(artesanoUpdate);
            return artesanoUpdate;
        } else {
        	throw new UserNotFoundException(id);
        }
    }

}
