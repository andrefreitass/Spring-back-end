package com.zends.condominio.comum.exception;

public class DataException extends RuntimeException{
	
	private static final long serialVersionUID = -6660916862753191168L;
	
	public DataException(String mensagem) {
		super(mensagem);
	}
	
	public DataException(String mensagem, Throwable causa) {
		super(mensagem,causa);
	}

}
