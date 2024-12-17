package org.generation.raicesmx.exception;

public class StatusNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public StatusNotFoundException(Long id) {
		super("El status con el id "+ id + " no se encuentra");
	}
}
