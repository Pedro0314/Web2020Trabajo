package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Caso;

public interface ICasoService {
	
	public boolean insertar(Caso caso);
	public boolean modificar(Caso caso);
	public void eliminar(int idCaso);
	public Optional<Caso> buscarId(int idCaso);
	public Optional<Caso> listarId(int idCaso);
	public List<Caso> listar();
	public List<Caso> buscarNumeroJuzgado(int numeroJuzgado);
	public List<Caso> buscarDomicilioCliente(String domicilioLegal);
	
	
}
