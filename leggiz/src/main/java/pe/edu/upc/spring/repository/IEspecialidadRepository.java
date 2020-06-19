package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Especialidad;

@Repository

public interface IEspecialidadRepository extends JpaRepository<Especialidad, Integer>{
	@Query("from Especialidad e where e.nombreEspecialidad like %:nombreEspecialidad%")
	List<Especialidad> buscarNombre(@Param("nombreEspecialidad") String nombreEspecialidad);
}
