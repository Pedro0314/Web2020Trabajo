package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Caso;
import pe.edu.upc.spring.repository.ICasoRepository;
import pe.edu.upc.spring.service.ICasoService;

@Service
public class CasoServiceImpl implements ICasoService {
	
	@Autowired
	private ICasoRepository dCaso;

	@Override
	@Transactional
	public boolean insertar(Caso caso) {
		Caso objCaso = dCaso.save(caso);
		if (objCaso!=null)
			return true;
		else 
			return false;
	}

	@Override
	@Transactional
	public boolean modificar(Caso caso) {
		boolean flag = false;
		try {
			dCaso.save(caso);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idCaso) {
		dCaso.deleteById(idCaso);
	}

	@Override
	public Optional<Caso> buscarId(int idCaso) {
		return dCaso.findById(idCaso);	}

	@Override
	public Optional<Caso> listarId(int idCaso) {
		return dCaso.findById(idCaso);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Caso> listar() {
		return dCaso.findAll();
	}

	@Override
	@Transactional
	public List<Caso> buscarNumeroJuzgado(int numeroJuzgado) {
		return dCaso.buscarJuzgado(numeroJuzgado);
	}
	
	@Override
	@Transactional
	public List<Caso> buscarDomicilioCliente(String domicilioLegal) {
		return dCaso.buscarDomicilio(domicilioLegal);
		
	}


}
