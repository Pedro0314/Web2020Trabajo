package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Abogado;
import pe.edu.upc.spring.repository.IAbogadoRepository;
import pe.edu.upc.spring.service.IAbogadoService;

@Service
public class AbogadoServiceImpl implements IAbogadoService {
	
	@Autowired
	private IAbogadoRepository dAbogado;

	@Override
	@Transactional
	public boolean insertar(Abogado abogado) {
		Abogado objAbogado = dAbogado.save(abogado);
		if (objAbogado!=null)
			return true;
		else 
			return false;
	}

	@Override
	@Transactional
	public boolean modificar(Abogado abogado) {
		boolean flag = false;
		try {
			dAbogado.save(abogado);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idAbogado) {
		dAbogado.deleteById(idAbogado);
	}

	@Override
	public Optional<Abogado> buscarId(int idAbogado) {
		return dAbogado.findById(idAbogado);	}

	@Override
	public Optional<Abogado> listarId(int idAbogado) {
		return dAbogado.findById(idAbogado);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Abogado> listar() {
		return dAbogado.findAll();
	}

	@Override
	@Transactional
	public List<Abogado> buscarNombre(String nameAbogado) {
		return dAbogado.buscarNombre(nameAbogado);
	}
	
	@Override
	@Transactional
	public List<Abogado> buscarEspecialidad(String nameEspecialidad) {
		return dAbogado.buscarEspecialidad(nameEspecialidad);
		
	}


}
