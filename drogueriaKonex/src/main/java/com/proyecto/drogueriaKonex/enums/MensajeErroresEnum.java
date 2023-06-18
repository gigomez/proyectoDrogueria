/**
 * 
 */
package com.proyecto.drogueriaKonex.enums;

/**
 * @author gloir
 *
 */
public enum MensajeErroresEnum {
	
	ERROR_001("La cantidad maxima permitida de caracteres es 50", "ERROR_001"),
	ERROR_002("El medicamento no existe en la base de datos","ERROR_002"),
	ERROR_003("La cantidad a comprar sobrepasa a la existente","ERROR_003")
	;
	
	private String message;
	private String code;
	
	MensajeErroresEnum(String message, String code) {
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public String getCode() {
		return code;
	}

}
