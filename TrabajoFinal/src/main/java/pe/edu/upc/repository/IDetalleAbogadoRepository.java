package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.DetalleAbogado;

@Repository

public interface IDetalleAbogadoRepository extends JpaRepository<DetalleAbogado, Integer>{
	@Query("from DetalleAbogado d where d.nombre like %:nombre%")
	List<DetalleAbogado> buscarNombre(@Param("nombre") String nombre);
	
	@Query("from DetalleAbogado d where d.especialidad.nombreEspecialidad like %:nombreEspecialidad%")
	List<DetalleAbogado> buscarEspecialidad(@Param("nombreEspecialidad") String nombreEspecialidad);
	
	@Query("from DetalleAbogado d where d.dueno.nameDueno like %:nameDueno%")
	List<DetalleAbogado> buscarCliente(@Param("nombre") String nombre);
}
