/**
 * 
 */
package com.proyecto.drogueriaKonex.interfaces;

import java.util.List;

import com.proyecto.drogueriaKonex.DTOs.MedicamentoDTO;
import com.proyecto.drogueriaKonex.exception.DrogueriaKonexException;

/**
 * Clase que permite invocar los metodos que van a ser utilizados para 
 * gestionar los servicios de gestion de Medicamentos del proyecto
 * @author Gloria Irma Gómez Patiño
 * @version 1.0
 *
 */
public interface IGestionarMedicamento {
	
	public void crearMedicamento(MedicamentoDTO medicamentoDto) throws DrogueriaKonexException;
	
	public List<MedicamentoDTO> obtenerMedicamentos() throws DrogueriaKonexException;

	public void actualizarMedicamento(MedicamentoDTO medicamentoDto) throws DrogueriaKonexException;

	
	public void eliminarMedicamento(Long idMedicamento) throws DrogueriaKonexException;
	
	
}
