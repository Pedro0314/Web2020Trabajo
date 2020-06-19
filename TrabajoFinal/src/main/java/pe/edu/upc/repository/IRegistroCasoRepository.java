package pe.edu.upc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.RegistroCaso;

@Repository
public interface IRegistroCasoRepository extends JpaRepository<RegistroCaso, Integer>{
	@Query("from RegistroCaso p where p.descripRegistroCaso like %:descripRegistroCaso%")
	List<RegistroCaso> buscarNombre(@Param("descripRegistroCaso") String descripRegistroCaso);
	
	@Query("from RegistroCaso p where p.caso.nameCaso like %:nameCaso%")
	List<RegistroCaso> buscarCaso(@Param("nameCaso") String nameCaso);
	
	@Query("from RegistroCaso p where p.abogado.nameAbogado like %:nameAbogado%")
	List<RegistroCaso> buscarAbogado(@Param("nameAbogado") String nameAbogado);
	
}
