package pe.edu.upc.spring.controller;

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

import pe.edu.upc.spring.model.Especialidad;
import pe.edu.upc.spring.model.Detalle;
import pe.edu.upc.spring.model.DetalleAbogado;

import pe.edu.upc.spring.service.IEspecialidadService;
import pe.edu.upc.spring.service.IDetalleService;
import pe.edu.upc.spring.service.IDetalleAbogadoService;

@Controller
@RequestMapping("/detalleAbogado")
public class DetalleAbogadoController {
	
	@Autowired
	private IDetalleAbogadoService pService;
	
	@Autowired
	private IEspecialidadService rService;
	
	@Autowired
	private IDetalleService dService;
		
	@RequestMapping("/")
	public String irPaginaListadoMascotas(Map<String, Object> model) {
		model.put("listaDetalleAbogados", pService.listar());
		return "listDetalleAbogados";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroMascotas(Model model) {
		model.addAttribute("listaEspecialidades", rService.listar());
		model.addAttribute("listaDetalles", dService.listar());		
		model.addAttribute("detalle", new Detalle());
		model.addAttribute("detalleAbogado", new DetalleAbogado());
		model.addAttribute("especialidad", new Especialidad());
		return "detalleAbogado";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid DetalleAbogado objDetalleAbogado, BindingResult binRes, Model model)
	throws ParseException{
		if(binRes.hasErrors()) 
		{
			model.addAttribute("listaEspecialidades", rService.listar());
			model.addAttribute("listaDetalles", dService.listar());					
			return "detalleAbogado";
		}
		else
		{
			boolean flag = pService.insertar(objDetalleAbogado);
			if(flag) {
				return "redirect:/detalleAbogado/listar";
			}
			else {
				model.addAttribute("mensaje ", "Ocurrió un roche");
				return "redirect:/detalleAbogado/irRegistrar";
			}
		}
	}
		
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
	throws ParseException{
		
		Optional<DetalleAbogado> objDetalleAbogado = pService.buscarId(id);
		
		if(objDetalleAbogado == null)
		{
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/detalleAbogado/listar";
		}
		else 
		{
			model.addAttribute("listaRazas", rService.listar());
			model.addAttribute("listaDuenos", dService.listar());
			
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
				pService.eliminar(id);
				model.put("listaDetalleAbogados", pService.listar());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaDetalleAbogados", pService.listar());
		}
		return "listDetalleAbogados";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaDetalleAbogados", pService.listar());
		return "listDetalleAbogados";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object>model, @ModelAttribute DetalleAbogado detalleAbogado)
	throws ParseException{
		pService.listarId(detalleAbogado.getIdDetalleAbogado());
		return "listDetalleAbogados";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object>model, @ModelAttribute DetalleAbogado detalleAbogado)
	throws ParseException{
		List<DetalleAbogado> listaDetalleAbogados;
		detalleAbogado.setIdDetalleAbogado(detalleAbogado.getIdDetalleAbogado());
		listaDetalleAbogados = pService.buscarNombre(detalleAbogado.getIdDetalleAbogado());
		
		if(listaDetalleAbogados.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaMascotas", listaDetalleAbogados);
		return "buscar";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("detalleAbogado",new DetalleAbogado());
		return "buscar";
	}
}