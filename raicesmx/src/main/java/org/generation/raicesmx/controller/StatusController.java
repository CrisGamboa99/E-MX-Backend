package org.generation.raicesmx.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import org.generation.raicesmx.exception.StatusNotFoundException;
import org.generation.raicesmx.model.StatusEntity;
import org.generation.raicesmx.service.StatusService;
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
@RequestMapping(path = "api/v1/status")
@CrossOrigin(origins="*")
public class StatusController {

	private final StatusService statusService;
	
	@Autowired
	public StatusController(StatusService statusService) {
		this.statusService = statusService;
	}
	
	@GetMapping("/getall")
	public List<StatusEntity> getAllStatus(){
		return this.statusService.getAllStatus();
	}
	
	@GetMapping("/get/{id}")
	public StatusEntity getStatus(@PathVariable("id") Long id) {
		return this.statusService.getStatus(id);
	}
	
	@GetMapping("/tipo/{nombre}")
	public ResponseEntity<StatusEntity> findByStatus(@PathVariable(name = "nombre") String nombre){
		if(this.statusService.findByStatus(nombre) == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(this.statusService.findByStatus(nombre));
	}
	
	@PostMapping("/new-status")
	public ResponseEntity<StatusEntity> createStatus(@RequestBody StatusEntity newStatus){
		if(this.statusService.findByStatus(newStatus.getTipo_status()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(this.statusService.createStatus(newStatus));
	}
	
	@DeleteMapping("/delete/{id_status}")
    public void deleteStatus(@PathVariable("id_status") Long id_status){
        this.statusService.deleteStatus(id_status);
    }
	
	@PutMapping("/put/{id_status}") 
	public ResponseEntity<?> updateStatus(@RequestBody StatusEntity statusModelo,@PathVariable("id_status") Long id_status){
		
		try {
			return ResponseEntity.ok(this.statusService.updateStatus(statusModelo, id_status));
		} catch (StatusNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		
		/*StatusEntity status= statusService.getStatus(id_status);
		if (status==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			status.setTipo_status(statusModelo.getTipo_status());
			StatusEntity updateStatus= statusService.updateStatus(status);
			return new ResponseEntity<>(updateStatus,HttpStatus.OK);
		}*/
	}
}
