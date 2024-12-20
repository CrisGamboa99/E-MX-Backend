package org.generation.raicesmx.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import org.generation.raicesmx.exception.PedidoNotFoundException;
import org.generation.raicesmx.model.PedidoEntity;
import org.generation.raicesmx.service.PedidoService;
import org.generation.raicesmx.service.dto.PedidoDto;
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
@RequestMapping(path = "api/v1/pedido")
@CrossOrigin(origins="*")
public class PedidoController {

	private final PedidoService pedidoService;
	
	@Autowired
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@GetMapping("/getall")
	public List<PedidoEntity> getAllPedido(){
		return this.pedidoService.getAllPedido();
	}
	
	@GetMapping("/get/{id}")
	public PedidoEntity getPedido(@PathVariable("id") Long id) {
		return this.pedidoService.getPedido(id);
	}
	
	@PostMapping("/new-pedido")
	public ResponseEntity<PedidoEntity> createPedido(@RequestBody PedidoDto dto){
		// if(this.pedidoService.getPedido(newPedido.getId_pedido()) != null) {
			//return new ResponseEntity<>(HttpStatus.CONFLICT);
		//}
		return ResponseEntity.status(HttpStatus.CREATED).body(this.pedidoService.createPedido(dto));
	}
	
	@DeleteMapping("/delete/{id_pedido}")
    public void deletePedido(@PathVariable("id_pedido") Long id_pedido){
        this.pedidoService.deletePedido(id_pedido);
    }
	
	@PutMapping("/update/{id}")
    public ResponseEntity<?> updatePedido(@RequestBody PedidoEntity pedidoEntity, @PathVariable("id") Long id) {

		try {
			return ResponseEntity.ok(this.pedidoService.updatePedido(pedidoEntity, id));
		} catch (PedidoNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		
        /*PedidoEntity pedido = pedidoService.getPedido(id);

        // Si el artesano no existe mandar mensaje de error
        if (pedido == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Retorna un 404 si no se encuentra el artesano
        } else { // De lo contrario actualiza los datos del artesano
        	pedido.setId_pedido(pedidoEntity.getId_pedido());
            pedido.setTotal(pedidoEntity.getTotal());
            pedido.setDescripcion(pedidoEntity.getDescripcion());
            pedido.setEstado_pedido(pedidoEntity.getEstado_pedido());
            pedido.setFecha(pedidoEntity.getFecha());
            pedido.setClientes_idClientes(pedidoEntity.getClientes_idClientes());
            pedido.setProducto_idProducto(pedidoEntity.getProducto_idProducto());

        // Guardar al artesano 
        PedidoEntity updatePedido = pedidoService.updatePedido(pedido);

        // Retornar al artesano actualizado
        return new ResponseEntity<>(updatePedido, HttpStatus.OK);
        }*/
	}
}
