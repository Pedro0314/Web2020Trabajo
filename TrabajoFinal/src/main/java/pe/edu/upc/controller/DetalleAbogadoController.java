package pe.edu.upc.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.model.Cliente;
import pe.edu.upc.model.Especialidad;
import pe.edu.upc.model.DetalleAbogado;
import pe.edu.upc.service.IClienteService;
import pe.edu.upc.service.IEspecialidadService;
import pe.edu.upc.service.IDetalleAbogadoService;

@Controller
@RequestMapping("/detalleAbogado")
public class DetalleAbogadoController {
	@Autowired
	private IDetalleAbogadoService dService;
	
	@Autowired
	private IEspecialidadService eService;
	
	@Autowired
	private IClienteService cService;
		
	@RequestMapping("/")
	public String irPaginaListadoAbogados(Map<String, Object> model) {
		model.put("listaAbogados", dService.listar());
		return "listDetalleAbogados";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroAbogados(Model model) {
		model.addAttribute("listaEspecialidades", eService.listar());
		model.addAttribute("listaClientes", cService.listar());		
		model.addAttribute("dueno", new Cliente());
		model.addAttribute("pet", new DetalleAbogado());
		model.addAttribute("race", new Especialidad());
		return "detalleAbogado";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid DetalleAbogado objDetalleAbogado, BindingResult binRes, Model model)
	throws ParseException{
		if(binRes.hasErrors()) 
		{
			model.addAttribute("listaEspecialidades", eService.listar());
			model.addAttribute("listaClientes", cService.listar());					
			return "detalleAbogado";
		}
		else
		{
			boolean flag = dService.insertar(objDetalleAbogado);
			if(flag) {
				return "redirect:/detalleAbogado/listar";
			}
			else {
				model.addAttribute("mensaje ", "Ocurrió un error");
				return "redirect:/detalleAbogado/irRegistrar";
			}
		}
	}
		
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
	throws ParseException{
		
		Optional<DetalleAbogado> objDetalleAbogado = dService.buscarId(id);
		
		if(objDetalleAbogado == null)
		{
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/detalleAbogado/listar";
		}
		else 
		{
			model.addAttribute("listaEspecialidades", eService.listar());
			model.addAttribute("listaClientes", cService.listar());
			
			if (objDetalleAbogado.isPresent())
				objDetalleAbogado.ifPresent(o -> model.addAttribute("detalleAbogado", o));
			
			return "detalleAbogado";
		}		
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object>model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0)
			{
				dService.eliminar(id);
				model.put("listaAbogados", dService.listar());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaAbogados", dService.listar());
		}
		return "listDetalleAbogados";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaAbogados", dService.listar());
		return "listDetalleAbogados";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object>model, @ModelAttribute DetalleAbogado detalleAbogado)
	throws ParseException{
		dService.listarId(detalleAbogado.getIdCliente());
		return "listDetalleAbogados";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object>model, @ModelAttribute DetalleAbogado detalleAbogado)
	throws ParseException{
		List<DetalleAbogado> listaAbogados;
		detalleAbogado.setNombre(detalleAbogado.getNombre());
		listaAbogados = dService.buscarNombre(detalleAbogado.getNombre());
		
		if(listaAbogados.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaAbogados", listaAbogados);
		return "buscar";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("detalleAbogado",new DetalleAbogado());
		return "buscar";
	}
	
}
