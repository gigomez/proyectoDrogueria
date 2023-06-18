/**
 * 
 */
package com.proyecto.drogueriaKonex.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * clase donde se realiza el mapeo de las propiedades que va a tener un medicameto y las cuales 
 * van a ser giardadas en la base de datos 
 * @author Gloria Irma Gómez Patiño
 * @version 1.0
 *
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "MEDICAMENTO")
public class Medicamento {
	
	@Id
	@SequenceGenerator(name = "MEDICAMENTO_ID_MEDICAMENTO_GENERATOR", sequenceName = "SEQ_MEDICAMENTO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEDICAMENTO_ID_MEDICAMENTO_GENERATOR")
	@Column(name="ID_MEDICAMENTO")
	private Long idMedicamento;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="LABORATORIO")
	private String laboratorioFabrica;
	
	@Column(name="FECHA_FABRICACION")
	private LocalDate fechaFabricacion;
	
	@Column(name="FECHA_VENCIMIENTO")
	private LocalDate FechaVencimiento;
	
	@Column(name="CANTIDAD_STOCK")
	private Long cantidadStock;
	
	@Column(name="VALOR_UNITARIO")
	private BigDecimal valorUnitario;
	
	public Medicamento() {
		//constructor vacio
	}
	
	
	

}
