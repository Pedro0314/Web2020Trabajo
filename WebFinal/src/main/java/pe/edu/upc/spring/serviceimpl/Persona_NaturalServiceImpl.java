package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Persona_Natural;
import pe.edu.upc.spring.repository.IPersona_NaturalRepository;
import pe.edu.upc.spring.service.IPersona_NaturalService;

@Service
public class Persona_NaturalServiceImpl implements IPersona_NaturalService {
	
	@Autowired
	private IPersona_NaturalRepository dPersona_Natural;

	@Override
	@Transactional
	public boolean insertar(Persona_Natural personaNatural) {
		Persona_Natural objPersona_Natural = dPersona_Natural.save(personaNatural);
		if (objPersona_Natural!=null)
			return true;
		else 
			return false;
	}

	@Override
	@Transactional
	public boolean modificar(Persona_Natural personaNatural) {
		boolean flag = false;
		try {
			dPersona_Natural.save(personaNatural);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idPersona_Natural) {
		dPersona_Natural.deleteById(idPersona_Natural);
	}

	

	@Override
	public Optional<Persona_Natural> listarId(int dni) {
		return dPersona_Natural.findById(dni);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Persona_Natural> listar() {
		return dPersona_Natural.findAll();
	}

	@Override
	@Transactional
	public List<Persona_Natural> buscarNombre(String namePersonaN) {
		return dPersona_Natural.buscarNombre(namePersonaN);
	}
	
	


}
