package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Persona_Natural;

public interface IPersona_NaturalService {
	public boolean insertar(Persona_Natural personaNatural);
	public boolean modificar(Persona_Natural personaNatural);
	public void eliminar(int dni);
	public Optional<Persona_Natural> listarId(int dni);
	List<Persona_Natural> listar();
	List<Persona_Natural> buscarNombre(String namePersonaN);	
}
