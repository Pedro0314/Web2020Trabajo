package pe.edu.upc.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Caso;

@Repository
public interface ICasoRepository extends JpaRepository<Caso, Integer>{
	@Query("from Caso c where c.numeroJuzgado like %:numeroJuzgado%")
	List<Caso> buscarJuzgado(@Param("numeroJuzgado") int numeroJuzgado);
	
	@Query("from Caso c where c.cliente.domicilioLegal like %:domicilioLegal%")
	List<Caso> buscarDomicilio(@Param("domicilioLegal") String domicilioLegal);
}
