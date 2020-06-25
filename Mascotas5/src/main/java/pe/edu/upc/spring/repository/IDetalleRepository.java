package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Detalle;

@Repository
public interface IDetalleRepository extends JpaRepository<Detalle, Integer> {
	@Query("from Detalle r where r.nameDetalle like %:nameDetalle%")
	List<Detalle> buscarNombre(@Param("nameDetalle") String nameDetalle);
}
