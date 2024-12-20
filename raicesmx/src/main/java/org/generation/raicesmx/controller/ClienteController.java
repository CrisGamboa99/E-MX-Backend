package org.generation.raicesmx.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import org.generation.raicesmx.exception.UserNotFoundException;
import org.generation.raicesmx.model.ClienteEntity;
import org.generation.raicesmx.service.ClienteService;
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
@RequestMapping(path = "api/v1/cliente")
@CrossOrigin(origins="*")
public class ClienteController {

	private final ClienteService clienteService;
		
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
		
	@GetMapping("/getall")
	public List<ClienteEntity> getAllCliente(){
		return this.clienteService.getAllCliente();
	}
		
	@GetMapping("/get/{id}")
	public ClienteEntity getArtesano(@PathVariable("id") Long id) {
		return this.clienteService.getCliente(id);
	}
		
	@GetMapping("/email/{email}")
	public ResponseEntity<ClienteEntity> findByEmail(@PathVariable(name = "email") String email){
		if(this.clienteService.findByEmail(email) == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(this.clienteService.findByEmail(email));
	}
		
	@PostMapping("/new-cliente")
	public ResponseEntity<ClienteEntity> createCliente(@RequestBody ClienteEntity newCliente){
		if(this.clienteService.findByEmail(newCliente.getCorreo()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(this.clienteService.createCliente(newCliente));
	}
		
	@DeleteMapping("/delete/{id_cliente}")
    public void deleteCliente(@PathVariable("id_cliente") Long id_cliente){
		this.clienteService.deleteCliente(id_cliente);
    }

	@PutMapping("/update/{id}")
    public ResponseEntity<?> updateCliente(@RequestBody ClienteEntity clienteEntity, @PathVariable("id") Long id ){
		try {
			return ResponseEntity.ok(this.clienteService.updateCliente(clienteEntity, id));
		} catch (UserNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
			
		/*ClienteEntity cliente = clienteService.getCliente(id);
        cliente.setNombre( clienteEntity.getNombre() );
        cliente.setApellido(clienteEntity.getApellido());
        cliente.setCorreo( clienteEntity.getCorreo() );
        cliente.setContrasena( clienteEntity.getContrasena() );
        cliente.setDireccion( clienteEntity.getDireccion() );
        cliente.setTelefono( clienteEntity.getTelefono() );
        cliente.setCodigo_postal( clienteEntity.getCodigo_postal() );
        cliente.setEstado( clienteEntity.getEstado() );
        cliente.setTipo_usuario( clienteEntity.getTipo_usuario() );
        return clienteService.updateCliente( cliente );*/
    }
}
