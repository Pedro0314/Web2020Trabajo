package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Persona_Natural;

@Repository
public interface IPersona_NaturalRepository extends JpaRepository<Persona_Natural, Integer> {
	@Query("from Persona_Natural pe where pe.namePersonaN like %:namePersonaN%")
	List<Persona_Natural> buscarNombre(@Param("namePersonaN") String namePersonaN);
}
