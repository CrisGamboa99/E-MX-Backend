package org.generation.raicesmx.exception;

public class PedidoNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PedidoNotFoundException(Long id) {
		super("El pedido con el id "+ id + " no se encuentra");
	}
}
