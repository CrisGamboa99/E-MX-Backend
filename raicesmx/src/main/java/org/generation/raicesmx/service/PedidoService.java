package org.generation.raicesmx.service;

import java.util.List;
import java.util.Optional;

import org.generation.raicesmx.exception.PedidoNotFoundException;
import org.generation.raicesmx.exception.UserNotFoundException;
import org.generation.raicesmx.model.PedidoEntity;
import org.generation.raicesmx.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	
	private final PedidoRepository pedidoRepository;
	
	@Autowired
	public PedidoService (PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	public List<PedidoEntity> getAllPedido(){
        return this.pedidoRepository.findAll();
    }
	
	// Mostrar un registro por id
	public PedidoEntity getPedido(Long id_pedido){
	    return pedidoRepository.findById(id_pedido)
	    		.orElseThrow(() -> new UserNotFoundException(id_pedido));
	}

	
    public PedidoEntity createPedido (PedidoEntity newPedido) {
        return this.pedidoRepository.save(newPedido);
    }
    
    // Eliminar un registro por id
    public void deletePedido(Long id) {
    	if(this.pedidoRepository.existsById(id)) {
    		pedidoRepository.deleteById(id);
    	}else {
    		throw new PedidoNotFoundException(id);
    	}
    }
    
    // Editar un pedido
    public PedidoEntity updatePedido(PedidoEntity pedidoEntity, Long id) {
        Optional < PedidoEntity > pedidoDb = this.pedidoRepository.findById(pedidoEntity.getId_pedido());

        if (pedidoDb.isPresent()) {
            PedidoEntity pedidoUpdate = pedidoDb.get();
            pedidoUpdate.setTotal(pedidoEntity.getTotal());
            pedidoUpdate.setDescripcion(pedidoEntity.getDescripcion());
            pedidoUpdate.setEstado_pedido(pedidoEntity.getEstado_pedido());
            pedidoUpdate.setFecha(pedidoEntity.getFecha());
            pedidoRepository.save(pedidoUpdate);
            return pedidoUpdate;
        } else {
        	throw new PedidoNotFoundException(id);
        }
    }
}
