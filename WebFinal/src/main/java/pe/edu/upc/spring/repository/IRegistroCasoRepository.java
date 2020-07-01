package pe.edu.upc.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.RegistroCaso;

@Repository
public interface IRegistroCasoRepository extends JpaRepository<RegistroCaso, Integer>{
	@Query("from RegistroCaso rc where rc.descripcion like %:descripcion%")
	List<RegistroCaso> buscarDescripcion(@Param("descripcion") String descripcion);
	
	@Query("from RegistroCaso rc where rc.abogado.nameAbogado like %:nameAbogado%")
	List<RegistroCaso> buscarAbogado(@Param("nameAbogado") String nameAbogado);

	@Query("from RegistroCaso rc where rc.caso.numeroJuzgado like %:numeroJuzgado%")
	List<RegistroCaso> buscarCaso(@Param("numeroJuzgado") int numeroJuzgado);
}
