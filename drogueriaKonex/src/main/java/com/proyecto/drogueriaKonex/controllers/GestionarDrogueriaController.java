/**
 * 
 */
package com.proyecto.drogueriaKonex.controllers;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.drogueriaKonex.DrogueriaKonexApplication;
import com.proyecto.drogueriaKonex.DTOs.MedicamentoDTO;
import com.proyecto.drogueriaKonex.DTOs.VentaDTO;
import com.proyecto.drogueriaKonex.exception.DrogueriaKonexException;
import com.proyecto.drogueriaKonex.interfaces.IGestionarMedicamento;
import com.proyecto.drogueriaKonex.interfaces.IGestionarVenta;
import com.proyecto.drogueriaKonex.model.Medicamento;
import com.proyecto.drogueriaKonex.model.Venta;
import com.proyecto.drogueriaKonex.repository.VentaRepository;
import com.proyecto.drogueriaKonex.repository.MedicamentoRepository;

/**
 * @author gloir
 *
 */
@RestController
@RequestMapping("drogueria")
@CrossOrigin(origins = "http://localhost:4200")
public class GestionarDrogueriaController {
	
	private final static Logger LOG = LogManager.getLogger(DrogueriaKonexApplication.class);
	
	@Autowired
	private IGestionarMedicamento medicamentoService;
	
	@Autowired
	private IGestionarVenta ventaService;
    
	
	//localhost:8080/drogueria/crearMedicamento
	@PostMapping("crearMedicamento")
	public ResponseEntity<?> crearMedicamento(@RequestBody MedicamentoDTO medicamentoDto) throws DrogueriaKonexException {	
		LOG.info("Inicia crearMedicamento con data {}", "");
		
		medicamentoService.crearMedicamento(medicamentoDto);
		String response = "Se ha creado el medicamento exitosamente"; 
		LOG.info("Finaliza createMedicamento() con response {}", response);
		return ResponseEntity.ok(response);
	}

	//localhost:8080/drogueria/obtenerMedicamentos
	@GetMapping("obtenerMedicamentos")
	public ResponseEntity<?> obtenerMedicamentos() throws Exception {
	
		return ResponseEntity.ok(medicamentoService.obtenerMedicamentos());
	}
	
	//localhost:8080/drogueria/actualizarMedicamento
		@PutMapping("actualizarMedicamento")
		public ResponseEntity<?> actualizarMedicamento(@RequestBody MedicamentoDTO medicamentoDto) throws DrogueriaKonexException {	
			LOG.info("Inicia crearMedicamento con data {}", "");
			
			medicamentoService.crearMedicamento(medicamentoDto);
			String response = "Se ha creado el medicamento exitosamente"; 
			LOG.info("Finaliza creaarMedicamento() con response {}", response);
			return ResponseEntity.ok(response);
		}
	
		//localhost:8080/drogueria/eliminarMedicamento
		@DeleteMapping("eliminarMedicamento/{idMedicamento}")
		public ResponseEntity<?> eliminarMedicamento(@PathVariable(name = "idMedicamento") Long idMedicamento) throws DrogueriaKonexException {	
			LOG.info("Inicia eliminarMedicamento con data {}", "");
			
			medicamentoService.eliminarMedicamento(idMedicamento);
			String response = "Se ha eliminado el medicamento exitosamente"; 
			LOG.info("Finaliza eliminarComic() con response {}", response);
			return ResponseEntity.ok(response);
		}
	
		
		//localhost:8080/drogueria/crearVenta
		@PostMapping("crearVenta")
		public ResponseEntity<?> crearVenta(@RequestBody VentaDTO ventaDto) throws DrogueriaKonexException {	
			LOG.info("Inicia crearVenta con data {}", "");
			ventaService.crearVenta(ventaDto);
			String response = "Se ha creado la venta exitosamente"; 
			LOG.info("Finaliza createVenta() con response {}", response);
			return ResponseEntity.ok(response);
		}

		
		
		//localhost:8080/drogueria/obtenerVenta
		@GetMapping("obtenerVenta")
		public ResponseEntity<?> obtenerVenta() throws Exception {
		
			return ResponseEntity.ok(ventaService.obtenerVenta());
		}
		
		
}
