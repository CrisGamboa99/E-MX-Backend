	package org.generation.raicesmx.controller;

import java.util.List;

import org.generation.raicesmx.model.ArtesanoEntity;
import org.generation.raicesmx.service.ArtesanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/artesano")
public class ArtesanoController {

	private final ArtesanoService artesanoService;
	
	@Autowired
	public ArtesanoController(ArtesanoService artesanoService) {
		this.artesanoService = artesanoService;
	}
	
	@GetMapping("/getall")
	public List<ArtesanoEntity> getAllArtesano(){
		return this.artesanoService.getAllArtesano();
	}
	
	@GetMapping("/get/{id}")
	public ArtesanoEntity getArtesano(@PathVariable("id") Long id) {
		return this.artesanoService.getArtesano(id);
	}
	
	@PostMapping("/new-user")
	public ArtesanoEntity createArtesano(@RequestBody ArtesanoEntity newArtesano){
		return this.artesanoService.createArtesano(newArtesano);
	}
	
	@DeleteMapping("/delete/{id_artesano}")
    public void deleteArtesano(@PathVariable("id_artesano") Long id_artesano){
        artesanoService.deleteArtesano(id_artesano);
    }

	@PutMapping("/update/{id}")
    public ResponseEntity<ArtesanoEntity> updateArtesano(@RequestBody ArtesanoEntity artesanoEntity, @PathVariable("id") Long id ){
        ArtesanoEntity artesano = artesanoService.getArtesano(id);
        
        if (artesano == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Retorna un 404 si no se encuentra el artesano
        } else { // De lo contrario actualiza los datos del artesano
        	artesano.setNombre( artesanoEntity.getNombre() );
        	artesano.setApellido( artesanoEntity.getApellido() );
        	artesano.setEmpresa( artesanoEntity.getEmpresa() );
        	artesano.setCorreo( artesanoEntity.getCorreo() );
        	artesano.setPassword( artesanoEntity.getPassword() );
        	artesano.setDireccion( artesanoEntity.getDireccion() );
        	artesano.setTelefono( artesanoEntity.getTelefono() );
        	artesano.setCodigo_postal( artesanoEntity.getCodigo_postal() );
        	artesano.setEstado( artesanoEntity.getEstado() );
        	artesano.setTipo_usuario( artesanoEntity.getTipo_usuario() );

        	// Guardar al artesano 
            ArtesanoEntity updateArtesano = artesanoService.updateArtesano(artesano);
            
            // Retornar al artesano actualizado
            return new ResponseEntity<>(updateArtesano, HttpStatus.OK);
        }
    }
}

