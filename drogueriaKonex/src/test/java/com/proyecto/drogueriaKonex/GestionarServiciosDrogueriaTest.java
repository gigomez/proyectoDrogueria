/**
 * 
 */
package com.proyecto.drogueriaKonex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.proyecto.drogueriaKonex.DTOs.MedicamentoDTO;
import com.proyecto.drogueriaKonex.DTOs.VentaDTO;
import com.proyecto.drogueriaKonex.controllers.GestionarDrogueriaController;
import com.proyecto.drogueriaKonex.exception.DrogueriaKonexException;
import com.proyecto.drogueriaKonex.repository.MedicamentoRepository;
import com.proyecto.drogueriaKonex.services.GestionarServiciosDrogueria;

/**
 * validacion pruebas unitarias para los servicios
 * @author Gloria Irma Gómez Patiño
 *
 */
public class GestionarServiciosDrogueriaTest {

	
	@InjectMocks
	private GestionarDrogueriaController gestionarDrogueriaController;
	
	

	
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void whenCreateMedicamentoGivenNewMedicamentoThenResponseSuccess() throws DrogueriaKonexException {
		//any()
		ResponseEntity<?> response = gestionarDrogueriaController.crearMedicamento(new MedicamentoDTO());
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void whenCreateVentaGivenNewMedicamentoThenResponseSuccess() throws DrogueriaKonexException {
		
		VentaDTO ventaDto  = new VentaDTO();
		ventaDto.setIdMedicamento(2L);
		ventaDto.setCantidadComprada(1L);
		ventaDto.setFechaVenta(LocalDateTime.now());
		ventaDto.setIdVenta(5L);
		ventaDto.setNombre("Loratadina 10 mg  x 20 tabletas");
		ventaDto.setValorUnitario(new BigDecimal(200));
		ventaDto.setValorTotal(new BigDecimal(200));
		
		
		ResponseEntity<?> response = gestionarDrogueriaController.crearVenta(ventaDto);
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
