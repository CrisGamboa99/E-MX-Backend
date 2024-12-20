	package org.generation.raicesmx.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import org.generation.raicesmx.exception.UserNotFoundException;
import org.generation.raicesmx.model.ArtesanoEntity;
import org.generation.raicesmx.service.ArtesanoService;
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
@RequestMapping(path = "api/v1/artesano")
@CrossOrigin(origins="*")
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
	public ArtesanoEntity getArtesano(@PathVariable(name = "id") Long id) {
		return this.artesanoService.getArtesano(id);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<ArtesanoEntity> findByEmail(@PathVariable(name = "email") String email){
		if(this.artesanoService.findByEmail(email) == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(this.artesanoService.findByEmail(email));
	}
	
	@PostMapping("/new-user")
	public ResponseEntity<ArtesanoEntity> createArtesano(@RequestBody ArtesanoEntity newArtesano){
		if(this.artesanoService.findByEmail(newArtesano.getCorreo()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(this.artesanoService.createArtesano(newArtesano));
	}

	
	@DeleteMapping("/delete/{id_artesano}")
    public void deleteArtesano(@PathVariable(name = "id_artesano") Long id_artesano){
        this.artesanoService.deleteArtesano(id_artesano);
    }

	@PutMapping("/update/{id}")
    public ResponseEntity<?> updateArtesano(@RequestBody ArtesanoEntity artesanoEntity, @PathVariable(name = "id") Long id ){
        
		try {
			return ResponseEntity.ok(this.artesanoService.updateArtesano(artesanoEntity, id));
		} catch (UserNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		
		/* ArtesanoEntity artesano = artesanoService.getArtesano(id);
        
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
        } */
    }
}

