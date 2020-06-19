package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Abogado;

@Repository
public interface IAbogadoRepository extends JpaRepository<Abogado, Integer>{
	@Query("from Abogado p where p.nameAbogado like %:nameAbogado%")
	List<Abogado> buscarNombre(@Param("nameAbogado") String nameAbogado);
	
	@Query("from Abogado p where p.especialidad.nameEspecialidad like %:nameEspecialidad%")
	List<Abogado> buscarEspecialidad(@Param("nameEspecialidad") String nameEspecialidad);

}
