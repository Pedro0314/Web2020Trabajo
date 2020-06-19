package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Abogado;

public interface IAbogadoService {
	
	public boolean insertar(Abogado abogado);
	public boolean modificar(Abogado abogado);
	public void eliminar(int idAbogado);
	public Optional<Abogado> buscarId(int idAbogado);
	public Optional<Abogado> listarId(int idAbogado);
	public List<Abogado> listar();
	public List<Abogado> buscarNombre(String nameAbogado);
	public List<Abogado> buscarEspecialidad(String nameEspecialidad);
	
}
