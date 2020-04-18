package com.zends.condominio.comum.exception;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -6660916862753191168L;

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String messagem) {
		errors.add(new FieldMessage(fieldName, messagem));
	}

}
