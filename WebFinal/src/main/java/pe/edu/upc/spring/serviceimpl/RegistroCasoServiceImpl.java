package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.RegistroCaso;
import pe.edu.upc.spring.repository.IRegistroCasoRepository;
import pe.edu.upc.spring.service.IRegistroCasoService;

@Service
public class RegistroCasoServiceImpl implements IRegistroCasoService {
	
	@Autowired
	private IRegistroCasoRepository dRegistroCaso;

	@Override
	@Transactional
	public boolean insertar(RegistroCaso registroCaso) {
		RegistroCaso objRegistroCaso = dRegistroCaso.save(registroCaso);
		if (objRegistroCaso!=null)
			return true;
		else 
			return false;
	}

	@Override
	@Transactional
	public boolean modificar(RegistroCaso registroCaso) {
		boolean flag = false;
		try {
			dRegistroCaso.save(registroCaso);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idRegistro) {
		dRegistroCaso.deleteById(idRegistro);
	}

	@Override
	public Optional<RegistroCaso> buscarId(int idRegistro) {
		return dRegistroCaso.findById(idRegistro);	}

	@Override
	public Optional<RegistroCaso> listarId(int idRegistro) {
		return dRegistroCaso.findById(idRegistro);
	}

	@Override
	@Transactional(readOnly=true)
	public List<RegistroCaso> listar() {
		return dRegistroCaso.findAll();
	}

	@Override
	@Transactional
	public List<RegistroCaso> buscarDescripcion(String descripcion) {
		return dRegistroCaso.buscarDescripcion(descripcion);
	}
	
	@Override
	@Transactional
	public List<RegistroCaso> buscarAbogado(String nameAbogado) {
		return dRegistroCaso.buscarAbogado(nameAbogado);
		
	}

	@Override
	@Transactional
	public List<RegistroCaso> buscarCaso(int numeroJuzgado) {
		return dRegistroCaso.buscarCaso(numeroJuzgado);
		
	}

}
