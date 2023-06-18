/**
 * 
 */
package com.proyecto.drogueriaKonex.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.drogueriaKonex.DrogueriaKonexApplication;
import com.proyecto.drogueriaKonex.DTOs.MedicamentoDTO;
import com.proyecto.drogueriaKonex.DTOs.VentaDTO;
import com.proyecto.drogueriaKonex.enums.MensajeErroresEnum;
import com.proyecto.drogueriaKonex.exception.DrogueriaKonexException;
import com.proyecto.drogueriaKonex.interfaces.IGestionarMedicamento;
import com.proyecto.drogueriaKonex.interfaces.IGestionarVenta;
import com.proyecto.drogueriaKonex.model.Medicamento;
import com.proyecto.drogueriaKonex.model.Venta;
import com.proyecto.drogueriaKonex.repository.MedicamentoRepository;
import com.proyecto.drogueriaKonex.repository.VentaRepository;

//import jdk.internal.net.http.common.Log;

/**
 * clase que permite crear los servicios que seran invocados por el controlador para 
 * la drogueria
 * @author Gloria Irma Gómez Patiño
 * @version 1.0
 *
 */
@Service
public class GestionarServiciosDrogueria implements IGestionarMedicamento, IGestionarVenta{
	
	private final static Logger LOG = LogManager.getLogger(Exception.class);
	
	@Autowired
	private MedicamentoRepository medicamentoRepository;
	
	@Autowired
	private VentaRepository ventaRepository;
	
	@Autowired 
	private ModelMapper modelMapper;

	/**
	 * método que permite crear una venta en la base de datos
	 */
	public void crearVenta(VentaDTO ventaDto) throws DrogueriaKonexException {
		// TODO Auto-generated method stub
		LOG.info("Incia metodo crearVenta", "");
		Venta venta = modelMapper.map(ventaDto, Venta.class);
		Long idMedicamento = venta.getIdMedicamento();
		Long cantidadComprar = venta.getCantidadComprada();
		Long cantidadActual = medicamentoRepository.obtenerCantidadPorId(idMedicamento);
		
		
		//variable que permite crear la nueva cantidad de un medicamento
		Long nuevaCantidad;
		
		LocalDateTime fechaVenta = LocalDateTime.now();
		
		//si la cantidad a comprar es mayor que la cantidad en stock se presenta una exception 
		if(cantidadComprar>cantidadActual) {
		LOG.error("Se ha presentado excepcion DrogueriaKonexException con mensaje {}", 
				MensajeErroresEnum.ERROR_003.getMessage());
		throw new DrogueriaKonexException(MensajeErroresEnum.ERROR_003, idMedicamento.toString());
		
		}else {
			if(cantidadComprar<=cantidadActual) {
				nuevaCantidad = cantidadActual - cantidadComprar;
				venta.setFechaVenta(fechaVenta);
				medicamentoRepository.actualizarCantidadStockPorId(nuevaCantidad, idMedicamento);
				
				ventaRepository.save(venta);
				System.out.println("Compra exitosa");
				
				System.out.println("esta es la cantidad " + cantidadComprar+ " id medica " +
						idMedicamento + " cantidad actual " + cantidadActual + " nueva cantidad " +
						nuevaCantidad + "nombre" + venta.getNombre());
						
			}	
		}
		
	
		
		LOG.info("Termina método crearVenta", "");	
	}
		
	
	/**
	 * método que permite listar todas las ventas que se encuentren registradas en la base de datos
	 */
	public List<VentaDTO> obtenerVenta() throws DrogueriaKonexException {
		
		List<VentaDTO> listaVentasDto = new ArrayList<VentaDTO>();
		List<Venta> ventas =  ventaRepository.findAll();
				
		for(Venta venta : ventas) {
			VentaDTO ventaDto = modelMapper.map(venta, VentaDTO.class );
			listaVentasDto.add(ventaDto);
			
		}
	return listaVentasDto;
	}
	

	/**
	 * método que permite crear un medicamento en la base de datos
	 */
	public void crearMedicamento(MedicamentoDTO medicamentoDto) throws DrogueriaKonexException {
		// TODO Auto-generated method stub}
		
		LOG.info("Incia metodo crearMedicamento", "");
		
		if(medicamentoDto!= null && medicamentoDto.getNombre().length()>50) {
			LOG.error("Se ha presentado un error de tipo DrogueriaKonexException con mensaje{}", 
					MensajeErroresEnum.ERROR_001.getMessage());
			throw new DrogueriaKonexException(MensajeErroresEnum.ERROR_001);
		}
		
		Medicamento medicamento = modelMapper.map(medicamentoDto, Medicamento.class);
		medicamentoRepository.save(medicamento);
		LOG.info("Termina método crearMedicamento", "");
	}
	

	/**
	 * método que permite listar todos los medicamentos que se encuentren registrados en la base de datos
	 */
	public List<MedicamentoDTO> obtenerMedicamentos() throws DrogueriaKonexException {
		// TODO Auto-generated method stub
		
		List<MedicamentoDTO> listaMedicamentosDto = new ArrayList<MedicamentoDTO>();
	
		//List<Medicamento> medicamentos =  medicamentoRepository.obtenerMedicamentos();
		
		List<Medicamento> medicamentos =  medicamentoRepository.findAll();
		
		for(Medicamento medicamento : medicamentos) {
			
			MedicamentoDTO medicamentoDto = modelMapper.map(medicamento, MedicamentoDTO.class );
			listaMedicamentosDto.add(medicamentoDto);
		}
				
		return listaMedicamentosDto;
	}

	/**
	 * método que permite actualizar un medicamento en la base de datos
	 */
	public void actualizarMedicamento(MedicamentoDTO medicamentoDto) throws DrogueriaKonexException {
		// TODO Auto-generated method stub
		
		LOG.info("Incia metodo ActualizarMedicamento", "");
		Long idMedicamento = medicamentoDto.getIdMedicamento();
		if(!medicamentoRepository.findById(idMedicamento).isPresent()) {
			LOG.error("Se ha presentado un error de tipo DrogueriaKonexException con mensaje{}", 
					MensajeErroresEnum.ERROR_002.getMessage());
			throw new DrogueriaKonexException(MensajeErroresEnum.ERROR_002);
		}
		 Medicamento medicamento = modelMapper.map(medicamentoDto, Medicamento.class);
		 medicamentoRepository.save(medicamento);
		 
		 LOG.info("Termina metodo ActualizarMedicamento", "");
	}

	
	/**
	 * método que permite eliminar un medicamento en la base de datos
	 */
	public void eliminarMedicamento(Long idMedicamento) throws DrogueriaKonexException {
		// TODO Auto-generated method stub
		
		medicamentoRepository.deleteById(idMedicamento);
		
	}
	
	
	
	

}
