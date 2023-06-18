/**
 * 
 */
package com.proyecto.drogueriaKonex.exception;

import com.proyecto.drogueriaKonex.enums.MensajeErroresEnum;

/**
 * @author gloir
 *
 */
public class DrogueriaKonexException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * code
	 */
	private final String code; // code

	/**
	 * Error Code
	 */
	private final MensajeErroresEnum errorCodeEnum;
	
	/**
	 * params
	 */
	private Object[] params;
	
	public DrogueriaKonexException(MensajeErroresEnum errorCode)
		{
		super(errorCode.getMessage());
		this.errorCodeEnum = errorCode;
		this.code = errorCode.name();
		}
	
	

	public DrogueriaKonexException(MensajeErroresEnum errorCode, String... params ) {
		super(errorCode.getMessage());
		this.errorCodeEnum = errorCode;
		this.code = errorCode.name();
		this.params = params;
	}
	
	/**
	 * @return String
	 */
	public String getCode() {
		return code;
	}

	public MensajeErroresEnum getErrorCode() {
		return errorCodeEnum;
	}

	public Object[] getParams() {
		return params;
	}

}
