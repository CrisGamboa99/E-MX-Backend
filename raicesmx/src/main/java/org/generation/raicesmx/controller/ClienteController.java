	package org.generation.raicesmx.controller;

	import java.util.List;

	import org.generation.raicesmx.model.ClienteEntity;
	import org.generation.raicesmx.service.ClienteService;
	import org.springframework.beans.factory.annotation.Autowired;
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
		
		@PostMapping("/new-cliente")
		public ClienteEntity createCliente(@RequestBody ClienteEntity newCliente){
			return this.clienteService.createCliente(newCliente);
		}
		
		@DeleteMapping("/delete/{id_cliente}")
	    public void deleteCliente(@PathVariable("id_cliente") Long id_cliente){
	        clienteService.deleteCliente(id_cliente);
	    }

		@PutMapping("/update/{id}")
	    public ClienteEntity updateArtesano(@RequestBody ClienteEntity clienteEntity, @PathVariable("id") Long id )
	    {
			ClienteEntity cliente = clienteService.getCliente(id);
	        cliente.setNombre( clienteEntity.getNombre() );
	        cliente.setApellido(clienteEntity.getApellido());
	        cliente.setCorreo( clienteEntity.getCorreo() );
	        cliente.setContrasena( clienteEntity.getContrasena() );
	        cliente.setDireccion( clienteEntity.getDireccion() );
	        cliente.setTelefono( clienteEntity.getTelefono() );
	        cliente.setCodigo_postal( clienteEntity.getCodigo_postal() );
	        cliente.setEstado( clienteEntity.getEstado() );
	        cliente.setTipo_usuario( clienteEntity.getTipo_usuario() );
	        return clienteService.updateCliente( cliente );
	    }
}
