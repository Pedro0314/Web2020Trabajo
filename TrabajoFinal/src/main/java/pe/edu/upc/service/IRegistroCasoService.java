package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.RegistroCaso;

public interface IRegistroCasoService {
	
	public boolean insertar(RegistroCaso eegistroCaso);
	public boolean modificar(RegistroCaso registroCaso);
	public void eliminar(int idRegistroCaso);
	public Optional<RegistroCaso> buscarId(int idRegistroCaso);
	public Optional<RegistroCaso> listarId(int idRegistroCaso);
	public List<RegistroCaso> listar();
	public List<RegistroCaso> buscarNombre(String nameRegistroCaso);
	public List<RegistroCaso> buscarCaso(String nameCaso);
	public List<RegistroCaso> buscarAbogado(String nameAbogado);
	
}
