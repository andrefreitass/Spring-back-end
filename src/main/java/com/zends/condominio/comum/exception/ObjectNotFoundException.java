package com.zends.condominio.comum.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6660916862753191168L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg,cause);
	}
}