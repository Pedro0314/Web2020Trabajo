package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.RegistroCaso;

public interface IRegistroCasoService {
	
	public boolean insertar(RegistroCaso registroCaso);
	public boolean modificar(RegistroCaso registroCaso);
	public void eliminar(int idRegistro);
	public Optional<RegistroCaso> buscarId(int idRegistro);
	public Optional<RegistroCaso> listarId(int idRegistro);
	public List<RegistroCaso> listar();
	public List<RegistroCaso> buscarDescripcion(String descripcion);
	public List<RegistroCaso> buscarAbogado(String nameAbogado);
	public List<RegistroCaso> buscarCaso(int numeroJuzgado);
	
}
