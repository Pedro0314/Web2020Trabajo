package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.DetalleAbogado;

public interface IDetalleAbogadoService {
	
	public boolean insertar(DetalleAbogado detalleabogado);
	public boolean modificar(DetalleAbogado detalleabogado);
	public void eliminar(int idCliente);
	public Optional<DetalleAbogado> buscarId(int idCliente);
	public Optional<DetalleAbogado> listarId(int idCliente);
	public List<DetalleAbogado> listar();
	public List<DetalleAbogado> buscarNombre(String nombre);
	public List<DetalleAbogado> buscarEspecialidad(String nombreEspecialidad);
	public List<DetalleAbogado> buscarCliente(String nombre);

}
