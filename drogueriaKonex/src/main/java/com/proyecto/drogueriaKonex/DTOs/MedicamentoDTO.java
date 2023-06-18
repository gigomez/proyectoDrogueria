/**
 * 
 */
package com.proyecto.drogueriaKonex.DTOs;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author gloir
 *
 */
@Getter
@Setter
@ToString
public class MedicamentoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long idMedicamento;
	private String nombre;
	private String laboratorioFabrica;
	private LocalDate fechaFabricacion;
	private LocalDate FechaVencimiento;
	private Long cantidadStock;
	private BigDecimal valorUnitario;
	
	public MedicamentoDTO() {
		//Método constructor vacío
	}
	
	

}
