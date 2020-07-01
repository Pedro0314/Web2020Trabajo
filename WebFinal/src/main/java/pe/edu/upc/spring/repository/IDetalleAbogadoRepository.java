package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.DetalleAbogado;

@Repository
public interface IDetalleAbogadoRepository extends JpaRepository<DetalleAbogado, Integer>{
	@Query("from DetalleAbogado p where p.idDetalleAbogado like %:idDetalleAbogado%")
	List<DetalleAbogado> buscarNombre(@Param("idDetalleAbogado") int idDetalleAbogado);
	
	@Query("from DetalleAbogado p where p.especialidad.nameEspecialidad like %:nameEspecialidad%")
	List<DetalleAbogado> buscarEspecialidad(@Param("nameEspecialidad") String nameEspecialidad);
	
	@Query("from DetalleAbogado p where p.detalle.nameDetalle like %:nameDetalle%")
	List<DetalleAbogado> buscarDetalle(@Param("nameDetalle") String nameDetalle);
	
}
