package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.DetalleAbogado;

public interface IDetalleAbogadoService {
	
	public boolean insertar(DetalleAbogado detalleAbogado);
	public boolean modificar(DetalleAbogado detalleAbogado);
	public void eliminar(int idDetalleAbogado);
	public Optional<DetalleAbogado> buscarId(int idDetalleAbogado);
	public Optional<DetalleAbogado> listarId(int idDetalleAbogado);
	public List<DetalleAbogado> listar();
	public List<DetalleAbogado> buscarNombre(int idDetalleAbogado);
	public List<DetalleAbogado> buscarEspecialidad(String nameEspecialidad);
	public List<DetalleAbogado> buscarDetalle(String nameDetalle);
	
}
