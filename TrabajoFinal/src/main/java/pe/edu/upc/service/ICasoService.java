package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Caso;

public interface ICasoService {
	public boolean insertar(Caso caso);
	public boolean modificar(Caso caso);
	public void eliminar(int idCaso);
	public Optional<Caso> listarId(int idCaso);
	List<Caso> listar();
	List<Caso> buscarNombre(String nameCaso);	
}
