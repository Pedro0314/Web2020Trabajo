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

import pe.edu.upc.spring.model.Cliente;
import pe.edu.upc.spring.model.Especialidad;
import pe.edu.upc.spring.service.IEspecialidadService;

@Controller
@RequestMapping("/especialidad")
public class EspecialidadController {

	@Autowired
	private IEspecialidadService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEspecialidades(Map<String, Object> model) {
		model.put("listaEspecialidades", rService.listar());
		return "listEspecialidad";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("especialidad", new Especialidad());
		return "especialidad";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Especialidad objEspecialidad, BindingResult binRes, Model model)
	throws ParseException
	{
		if (binRes.hasErrors())
			return "especialidad";
		else 
		{
			boolean flag = rService.insertar(objEspecialidad);
			if (flag) {
				return "redirect:/especialidad/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/especialidad/irRegistrar";
			}
		}
	}
	

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
	throws ParseException
	{
		Optional<Especialidad> objEspecialidad = rService.listarId(id);
		if (objEspecialidad == null ) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un roche");
			return "redirect:/Especialidad/listar";
		}
		else {
			model.addAttribute("especialidad", objEspecialidad);
			return "especialidad";
		}
	}
	
	
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				rService.eliminar(id);
				model.put("listaEspecialidades", rService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaEspecialidades", rService.listar());
		}
		return "listEspecialidad";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaEspecialidades", rService.listar());
		return "listEspecialidad";
	}
	
	@RequestMapping("/irBuscar")
	public String buscar(Model model) {
		model.addAttribute("especialidad",new Especialidad());
		model.addAttribute("listEspecialidades", rService.listar());
		return "buscarEspecialidad";
	}
	
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object>model, @ModelAttribute Especialidad especialidad)
	throws ParseException{
		List<Especialidad>listaEspecialidades;
		especialidad.setNameEspecialidad(especialidad.getNameEspecialidad());
		listaEspecialidades=rService.buscarNombre(especialidad.getNameEspecialidad());
		
		if(listaEspecialidades.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaEspecialidades", listaEspecialidades);
		return "buscarEspecialidad";
	}
	
	
}
