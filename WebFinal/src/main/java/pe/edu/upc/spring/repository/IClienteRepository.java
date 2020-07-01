package pe.edu.upc.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer>{
	@Query("from Cliente c where c.domicilioLegal like %:domicilioLegal%")
	List<Cliente> buscarDomicilio(@Param("domicilioLegal") String domicilioLegal);
	
	@Query("from Cliente c where c.personaN.namePersonaN like %:namePersonaN%")
	List<Cliente> buscarPersonaNatural(@Param("namePersonaN") String namePersonaN);

	@Query("from Cliente c where c.persona.namePersona like %:namePersona%")
	List<Cliente> buscarPersonaJuridica(@Param("namePersona") String namePersona);
}
