package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.DetalleAbogado;
import pe.edu.upc.spring.repository.IDetalleAbogadoRepository;
import pe.edu.upc.spring.service.IDetalleAbogadoService;

@Service
public class DetalleAbogadoServiceImpl implements IDetalleAbogadoService {
	
	@Autowired
	private IDetalleAbogadoRepository dDetalleAbogado;

	@Override
	@Transactional
	public boolean insertar(DetalleAbogado detalleAbogado) {
		DetalleAbogado objDetalleAbogado = dDetalleAbogado.save(detalleAbogado);
		if (objDetalleAbogado!=null)
			return true;
		else 
			return false;
	}

	@Override
	@Transactional
	public boolean modificar(DetalleAbogado detalleAbogado) {
		boolean flag = false;
		try {
			dDetalleAbogado.save(detalleAbogado);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idDetalleAbogado) {
		dDetalleAbogado.deleteById(idDetalleAbogado);
	}

	@Override
	public Optional<DetalleAbogado> buscarId(int idDetalleAbogado) {
		return dDetalleAbogado.findById(idDetalleAbogado);	}

	@Override
	public Optional<DetalleAbogado> listarId(int idDetalleAbogado) {
		return dDetalleAbogado.findById(idDetalleAbogado);
	}

	@Override
	@Transactional(readOnly=true)
	public List<DetalleAbogado> listar() {
		return dDetalleAbogado.findAll();
	}

	@Override
	@Transactional
	public List<DetalleAbogado> buscarNombre(int idDetalleAbogado) {
		return dDetalleAbogado.buscarNombre(idDetalleAbogado);
	}
	
	@Override
	@Transactional
	public List<DetalleAbogado> buscarEspecialidad(String nameEspecialidad) {
		return dDetalleAbogado.buscarEspecialidad(nameEspecialidad);
		
	}

	@Override
	@Transactional
	public List<DetalleAbogado> buscarDetalle(String nameDetalle) {
		return dDetalleAbogado.buscarDetalle(nameDetalle);
	}	

}
