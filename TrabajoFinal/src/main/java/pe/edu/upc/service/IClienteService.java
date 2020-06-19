package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Cliente;

public interface IClienteService {

	public boolean insertar(Cliente cliente);
	public boolean modificar(Cliente cliente);
	public void eliminar(int idCliente);
	public Optional<Cliente> buscarId(int idCliente);
	public Optional<Cliente> listarId(int idCliente);
	public List<Cliente> listar();
	public List<Cliente> buscarNombre(String nombre);
	
}
