package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Especialidad;

public interface IEspecialidadService {
	public boolean insertar(Especialidad especialidad);
	public boolean modificar(Especialidad especialidad);
	public void eliminar(int idEspecialidad);
	public Optional<Especialidad> listarId(int idEspecialidad);
	List<Especialidad> listar();
	List<Especialidad> buscarNombre(String nameEspecialidad);	
}
