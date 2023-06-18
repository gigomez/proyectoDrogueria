/**
 * 
 */
package com.proyecto.drogueriaKonex.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.drogueriaKonex.model.Medicamento;

/**
 * @author gloir
 *
 */
@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
	

		@Query("SELECT m FROM Medicamento m order by m.nombre asc")
		List<Medicamento> obtenerMedicamentos();
		
		@Query("DELETE FROM Medicamento WHERE idMedicamento = :idMedicamento")
		@Modifying
		@Transactional
		Long eliminarMedicamentoPorId(@Param("idMedicamento") Long idMedicamento);
		
		//Obtener cantidad de un medicamento por id
		@Query("SELECT m.cantidadStock FROM Medicamento m WHERE m.idMedicamento = :idMed")
		Long  obtenerCantidadPorId(@Param("idMed") Long idMed);
		

		//actualizar cantidadStock por id	
		@Query("UPDATE Medicamento m SET m.cantidadStock = :cantidad WHERE m.idMedicamento = :idMed")
		@Modifying
		@Transactional
		int actualizarCantidadStockPorId(@Param("cantidad") Long cantidad, @Param("idMed") Long idMed);

	
}
