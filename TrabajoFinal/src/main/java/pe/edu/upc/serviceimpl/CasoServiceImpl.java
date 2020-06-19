package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Caso;
import pe.edu.upc.repository.ICasoRepository;
import pe.edu.upc.service.ICasoService;

@Service
public class CasoServiceImpl implements ICasoService {

	@Autowired
	private ICasoRepository dCaso;
	
	@Override
	@Transactional
	public boolean insertar(Caso caso) {
		Caso objCaso = dCaso.save(caso);
		if (objCaso == null)
			return false;
		else
			return true;
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
			System.out.println("Sucedio un roche");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idCaso) {
		dCaso.deleteById(idCaso);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Caso> listarId(int idCaso) {
		return dCaso.findById(idCaso);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Caso> listar() {
		return dCaso.findAll();
	}

	@Override
	@Transactional(readOnly=true)	
	public List<Caso> buscarNombre(String nameCaso) {		
		return dCaso.buscarNombre(nameCaso);
	}

}
