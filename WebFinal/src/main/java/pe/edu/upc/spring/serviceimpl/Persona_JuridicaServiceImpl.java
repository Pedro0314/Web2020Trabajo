package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Persona_Juridica;
import pe.edu.upc.spring.repository.IPersona_JuridicaRepository;
import pe.edu.upc.spring.service.IPersona_JuridicaService;

@Service
public class Persona_JuridicaServiceImpl implements IPersona_JuridicaService {
	
	@Autowired
	private IPersona_JuridicaRepository dPersona_Juridica;

	@Override
	@Transactional
	public boolean insertar(Persona_Juridica personaJuridica) {
		Persona_Juridica objPersona_Juridica = dPersona_Juridica.save(personaJuridica);
		if (objPersona_Juridica!=null)
			return true;
		else 
			return false;
	}

	@Override
	@Transactional
	public boolean modificar(Persona_Juridica personaJuridica) {
		boolean flag = false;
		try {
			dPersona_Juridica.save(personaJuridica);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idPersona_Juridica) {
		dPersona_Juridica.deleteById(idPersona_Juridica);
	}

	
	@Override
	public Optional<Persona_Juridica> listarId(int idPersona) {
		return dPersona_Juridica.findById(idPersona);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Persona_Juridica> listar() {
		return dPersona_Juridica.findAll();
	}

	@Override
	@Transactional
	public List<Persona_Juridica> buscarNombre(String namePersona) {
		return dPersona_Juridica.buscarNombre(namePersona);
	}
	
	
}
