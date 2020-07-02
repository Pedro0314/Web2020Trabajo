package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Especialidad;

public interface IEspecialidadService {
	public boolean insertar(Especialidad especialidad);
	public boolean modificar(Especialidad especialidad);
	public void eliminar(int idEspecialidad);
	public Optional<Especialidad> listarId(int idEspecialidad);
	List<Especialidad> listar();
	List<Especialidad> buscarNombre(String nameEspecialidad);	
	List<Especialidad> buscarporNombre(String nameEspecialidad);
}
