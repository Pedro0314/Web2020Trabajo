package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Persona_Juridica;

@Repository
public interface IPersona_JuridicaRepository extends JpaRepository<Persona_Juridica, Integer> {
	@Query("from Persona_Juridica pj where pj.namePersona like %:namePersona%")
	List<Persona_Juridica> buscarNombre(@Param("namePersona") String namePersona);
}
