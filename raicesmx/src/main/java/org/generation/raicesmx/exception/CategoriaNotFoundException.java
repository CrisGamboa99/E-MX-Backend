package org.generation.raicesmx.exception;

public class CategoriaNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CategoriaNotFoundException(Long id) {
		super("La categoria con el id "+ id + " no se encuentra");
	}
}
