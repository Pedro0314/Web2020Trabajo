package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Caso;

@Repository
public interface ICasoRepository extends JpaRepository<Caso, Integer> {
	@Query("from Caso r where r.nameCaso like %:nameCaso%")
	List<Caso> buscarNombre(@Param("nameCaso") String nameCaso);
}
