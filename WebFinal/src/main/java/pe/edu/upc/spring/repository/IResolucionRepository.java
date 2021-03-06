package pe.edu.upc.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Resolucion;

@Repository
public interface IResolucionRepository extends JpaRepository<Resolucion, Integer>{
	@Query("from Resolucion r where r.descripcion like %:descripcion%")
	List<Resolucion> buscarDescripcion(@Param("descripcion") String descripcion);
	
	@Query("from Resolucion r where r.caso.numeroJuzgado like %:numeroJuzgado%")
	List<Resolucion> buscarCaso(@Param("numeroJuzgado") int numeroJuzgado);
}
