/**
 * 
 */
package com.proyecto.drogueriaKonex.repository;

import org.springframework.stereotype.Repository;
import com.proyecto.drogueriaKonex.model.Venta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




/**
 * @author gloir
 *
 */
@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
	
//
//Select m.nombre,  m.cantidad_stock, m.valor_unitario, v.valor_total 
//from MEDICAMENTO m, VENTA v
//where m.id_medicamento = v.id_medicamento ;
//	


	@Query("SELECT v FROM Venta v ")
	List<Venta> obtenerVentas();
	
	

//
//					//actualizar cantidad por id	
//					@Query("UPDATE Comic c SET c.fechaVenta = :fechaVenta WHERE c.id = :idComic")
//					@Modifying
//					@Transactional
//					int actualizarFechaComicPorId(@Param("fechaVenta") LocalDate fechaVenta, @Param("idComic") Long idComic);

	//
//			//actualizar fecha y cantidad
//				@Query("UPDATE Comic c SET c.fechaVenta: fechaV, c.cantidad = :cantidad,  WHERE c.id = :idComic")
//				@Modifying
//				@Transactional
//				int actualizarFechaCantidadIdComic(@Param("fechaV") LocalDate fechaV, @Param("cantidad") Long cantidad, @Param("idComic") Long idComic);
//				

	
}
