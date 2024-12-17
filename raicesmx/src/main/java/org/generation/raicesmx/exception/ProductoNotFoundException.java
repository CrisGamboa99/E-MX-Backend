package org.generation.raicesmx.exception;

public class ProductoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductoNotFoundException(Long id) {
		super("El producto con el id "+ id + " no se encuentra");
	}
}
