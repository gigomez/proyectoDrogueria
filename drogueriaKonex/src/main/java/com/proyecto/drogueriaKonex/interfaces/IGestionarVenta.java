/**
 * 
 */
package com.proyecto.drogueriaKonex.interfaces;

import java.util.List;

import com.proyecto.drogueriaKonex.DTOs.MedicamentoDTO;
import com.proyecto.drogueriaKonex.DTOs.VentaDTO;
import com.proyecto.drogueriaKonex.exception.DrogueriaKonexException;

/**
 * Clase que permite invocar los metodos que van a ser utilizados para 
 * gestionar los servicios de gestion de ventas del proyecto
 * @author Gloria Irma Gómez Patiño
 * @version 1.0
 *
 */
public interface IGestionarVenta {
	
	public void crearVenta(VentaDTO ventaDto) throws DrogueriaKonexException;
	public List<VentaDTO> obtenerVenta() throws DrogueriaKonexException;

}
