/**
 * 
 */
package com.proyecto.drogueriaKonex.DTOs;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author gloir
 *
 */
@Setter
@Getter
@ToString
public class VentaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long idVenta;
	private Long idMedicamento;
	private Long cantidadComprada;
	private String nombre;
	private LocalDateTime FechaVenta;
	private BigDecimal valorUnitario;
	private BigDecimal valorTotal;
	
	
	public VentaDTO() {
		//Método constructor vacío
	}
	

}
