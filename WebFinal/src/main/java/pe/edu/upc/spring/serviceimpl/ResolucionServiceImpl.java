package pe.edu.upc.spring.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Resolucion;
import pe.edu.upc.spring.repository.IResolucionRepository;
import pe.edu.upc.spring.service.IResolucionService;

@Service
public class ResolucionServiceImpl implements IResolucionService {
	
	@Autowired
	private IResolucionRepository dResolucion;

	@Override
	@Transactional
	public boolean insertar(Resolucion resolucion) {
		Resolucion objResolucion = dResolucion.save(resolucion);
		if (objResolucion!=null)
			return true;
		else 
			return false;
	}

	@Override
	@Transactional
	public boolean modificar(Resolucion resolucion) {
		boolean flag = false;
		try {
			dResolucion.save(resolucion);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idResol) {
		dResolucion.deleteById(idResol);
	}

	@Override
	public Optional<Resolucion> buscarId(int idResol) {
		return dResolucion.findById(idResol);	}

	@Override
	public Optional<Resolucion> listarId(int idResol) {
		return dResolucion.findById(idResol);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Resolucion> listar() {
		return dResolucion.findAll();
	}

	@Override
	@Transactional
	public List<Resolucion> buscarDescripcion(String descripcion) {
		return dResolucion.buscarDescripcion(descripcion);
	}
	
	@Override
	@Transactional
	public List<Resolucion> buscarNumeroCaso(int numeroJuzgado) {
		return dResolucion.buscarCaso(numeroJuzgado);
		
	}


}
