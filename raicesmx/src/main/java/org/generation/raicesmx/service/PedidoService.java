package org.generation.raicesmx.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
	
	public PedidoEntity getPedido(Long id_pedido){
	    return pedidoRepository.findById(id_pedido).orElse(null);
	}

    public PedidoEntity createPedido (PedidoEntity newPedido) {
        return this.pedidoRepository.save(newPedido);
    }
    
    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }
    
    // Editar un pedido
    public PedidoEntity updatePedido(PedidoEntity pedidoEntity) {
        Optional < PedidoEntity > pedidoDb = this.pedidoRepository.findById(pedidoEntity.getId_pedido());

        if (pedidoDb.isPresent()) {
            PedidoEntity pedidoUpdate = pedidoDb.get();
            pedidoUpdate.setId_pedido(pedidoEntity.getId_pedido());
            pedidoUpdate.setTotal(pedidoEntity.getTotal());
            pedidoUpdate.setDescripcion(pedidoEntity.getDescripcion());
            pedidoUpdate.setEstado_pedido(pedidoEntity.getEstado_pedido());
            pedidoUpdate.setFecha(pedidoEntity.getFecha());
            pedidoUpdate.setClientes_idClientes(pedidoEntity.getClientes_idClientes());
            pedidoUpdate.setProducto_idProducto(pedidoEntity.getProducto_idProducto());
            pedidoRepository.save(pedidoUpdate);
            return pedidoUpdate;
        } else {
            throw new NoSuchElementException("No se encontró registro con id: " + pedidoEntity.getId_pedido());
        }
    }
}
