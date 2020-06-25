package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Detalle;

public interface IDetalleService {
	public boolean insertar(Detalle detalle);
	public boolean modificar(Detalle detalle);
	public void eliminar(int idDetalle);
	public Optional<Detalle> listarId(int idDetalle);
	List<Detalle> listar();
	List<Detalle> buscarNombre(String nameDetalle);	
}
