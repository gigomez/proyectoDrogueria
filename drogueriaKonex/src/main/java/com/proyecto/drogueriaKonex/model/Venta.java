/**
 * 
 */
package com.proyecto.drogueriaKonex.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@Entity
@Table(name = "VENTA")
public class Venta {
	
	@Id
	@SequenceGenerator(name = "VENTA_ID_VENTA_GENERATOR", sequenceName = "SEQ_VENTAS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VENTA_ID_VENTA_GENERATOR")
	@Column(name="ID_VENTA")
	private Long idVenta;
	
	//@ForeignKey()
	@Column(name="ID_MEDICAMENTO", nullable = false)
	//@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Long idMedicamento;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="CANTIDAD_COMPRADA")
	private Long cantidadComprada;
	
	@Column(name="FECHA_VENTA")
	private LocalDateTime FechaVenta;
	
	
	
	@Column(name="VALOR_UNITARIO")
	private BigDecimal valorUnitario;
	
	@Column(name="VALOR_TOTAL")
	private BigDecimal valorTotal;
	
	

	public Venta(){
		
		//constructor vacio
		
	}

}
