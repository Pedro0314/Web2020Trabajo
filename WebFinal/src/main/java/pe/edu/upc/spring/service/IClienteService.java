package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Cliente;

public interface IClienteService {
	
	public boolean insertar(Cliente cliente);
	public boolean modificar(Cliente cliente);
	public void eliminar(int idCliente);
	public Optional<Cliente> buscarId(int idCliente);
	public Optional<Cliente> listarId(int idCliente);
	public List<Cliente> listar();
	public List<Cliente> buscarDomicilio(String domicilioLegal);
	public List<Cliente> buscarPersonaJuridica(String namePersona);
	public List<Cliente> buscarPersonaNatural(String namePersonaN);
	
}
