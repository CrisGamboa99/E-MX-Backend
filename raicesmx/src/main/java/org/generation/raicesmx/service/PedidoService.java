package org.generation.raicesmx.service;

import java.util.List;
import java.util.Optional;

import org.generation.raicesmx.exception.PedidoNotFoundException;
import org.generation.raicesmx.exception.UserNotFoundException;
import org.generation.raicesmx.model.ClienteEntity;
import org.generation.raicesmx.model.PedidoEntity;
import org.generation.raicesmx.model.ProductoEntity;
import org.generation.raicesmx.repository.ClienteRepository;
import org.generation.raicesmx.repository.PedidoRepository;
import org.generation.raicesmx.service.dto.PedidoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	
	private final PedidoRepository pedidoRepository;
	private final ClienteRepository clienteRepository;
	
	@Autowired
	public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
		super();
		this.pedidoRepository = pedidoRepository;
		this.clienteRepository = clienteRepository;
	}
	
	public List<PedidoEntity> getAllPedido(){
        return this.pedidoRepository.findAll();
    }

	// Mostrar un registro por id
	public PedidoEntity getPedido(Long id_pedido){
	    return pedidoRepository.findById(id_pedido)
	    		.orElseThrow(() -> new UserNotFoundException(id_pedido));
	}

	
    public PedidoEntity createPedido (PedidoDto dto) {
    	ClienteEntity cliente = this.clienteRepository.findById(dto.getId_clientes()).orElseThrow(() -> new UserNotFoundException(dto.getId_clientes()));
	    
	    PedidoEntity pedido = new PedidoEntity();
	    
	    pedido.setTotal(dto.getTotal());
	    pedido.setDescripcion(dto.getDescripcion());
	    pedido.setEstado_pedido(dto.getEstado_pedido());
	    pedido.setFecha(dto.getFecha());

	    pedido.setClientes(cliente);
	    
	    return this.pedidoRepository.save(pedido);
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
