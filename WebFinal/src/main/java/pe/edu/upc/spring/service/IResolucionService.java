package pe.edu.upc.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Resolucion;

public interface IResolucionService {
	
	public boolean insertar(Resolucion resolucion);
	public boolean modificar(Resolucion resolucion);
	public void eliminar(int idResol);
	public Optional<Resolucion> buscarId(int idResol);
	public Optional<Resolucion> listarId(int idResol);
	public List<Resolucion> listar();
	public List<Resolucion> buscarFecha(Date Fecha);
	public List<Resolucion> buscarNumeroCaso(int numeroJuzgado);
	
	
}
