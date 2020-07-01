package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Persona_Juridica;

public interface IPersona_JuridicaService {
	public boolean insertar(Persona_Juridica personaJuridica);
	public boolean modificar(Persona_Juridica personaJuridica);
	public void eliminar(int idPersona);
	public Optional<Persona_Juridica> listarId(int idPersona);
	List<Persona_Juridica> listar();
	List<Persona_Juridica> buscarNombre(String namePersona);	
}
