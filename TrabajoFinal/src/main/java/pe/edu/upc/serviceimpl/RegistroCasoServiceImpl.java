package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.RegistroCaso;
import pe.edu.upc.repository.IRegistroCasoRepository;
import pe.edu.upc.service.IRegistroCasoService;

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
	public void eliminar(int idRegistroCaso) {
		dRegistroCaso.deleteById(idRegistroCaso);
	}

	@Override
	public Optional<RegistroCaso> buscarId(int idRegistroCaso) {
		return dRegistroCaso.findById(idRegistroCaso);	}

	@Override
	public Optional<RegistroCaso> listarId(int idRegistroCaso) {
		return dRegistroCaso.findById(idRegistroCaso);
	}

	@Override
	@Transactional(readOnly=true)
	public List<RegistroCaso> listar() {
		return dRegistroCaso.findAll();
	}

	@Override
	@Transactional
	public List<RegistroCaso> buscarNombre(String nameRegistroCaso) {
		return dRegistroCaso.buscarNombre(nameRegistroCaso);
	}
	
	@Override
	@Transactional
	public List<RegistroCaso> buscarCaso(String nameCaso) {
		return dRegistroCaso.buscarCaso(nameCaso);
		
	}

	@Override
	@Transactional
	public List<RegistroCaso> buscarAbogado(String nameAbogado) {
		return dRegistroCaso.buscarAbogado(nameAbogado);
	}	

}
