package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Especialidad;
import pe.edu.upc.spring.repository.IEspecialidadRepository;
import pe.edu.upc.spring.service.IEspecialidadService;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

	@Autowired
	private IEspecialidadRepository dEspecialidad;
	
	@Override
	@Transactional
	public boolean insertar(Especialidad especialidad) {
		Especialidad objEspecialidad = dEspecialidad.save(especialidad);
		if (objEspecialidad == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Especialidad especialidad) {
		boolean flag = false;
		try {
			dEspecialidad.save(especialidad);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un roche");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idEspecialidad) {
		dEspecialidad.deleteById(idEspecialidad);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Especialidad> listarId(int idEspecialidad) {
		return dEspecialidad.findById(idEspecialidad);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Especialidad> listar() {
		return dEspecialidad.findAll();
	}

	@Override
	@Transactional(readOnly=true)	
	public List<Especialidad> buscarNombre(String nameEspecialidad) {		
		return dEspecialidad.buscarNombre(nameEspecialidad);
	}
	
	@Override
	@Transactional(readOnly=true)	
	public List<Especialidad> buscarporNombre(String nameEspecialidad) {		
		return dEspecialidad.buscarporNombre(nameEspecialidad);
	}

}
