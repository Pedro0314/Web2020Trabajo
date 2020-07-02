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

import pe.edu.upc.spring.model.Caso;
import pe.edu.upc.spring.model.Resolucion;


import pe.edu.upc.spring.service.ICasoService;
import pe.edu.upc.spring.service.IResolucionService;

@Controller
@RequestMapping("/resolucion")
public class ResolucionController {
	
	@Autowired
	private IResolucionService rService;
	
	@Autowired
	private ICasoService cService;
	
	
		
	@RequestMapping("/")
	public String irPaginaListadoResoluciones(Map<String, Object> model) {
		model.put("listaResolucion", rService.listar());
		return "listResolucion";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroResolucion(Model model) {
		model.addAttribute("listaCasos", cService.listar());
		model.addAttribute("resolucion", new Resolucion());
		model.addAttribute("caso", new Caso());
		return "resolucion";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Resolucion objResolucion, BindingResult binRes, Model model)
	throws ParseException{
		if(binRes.hasErrors()) 
		{
			model.addAttribute("listaResoluciones", cService.listar());					
			return "resolucion";
		}
		else
		{
			boolean flag = rService.insertar(objResolucion);
			if(flag) {
				return "redirect:/resolucion/listar";
			}
			else {
				model.addAttribute("mensaje ", "Ocurrió un error");
				return "redirect:/resolucion/irRegistrar";
			}
		}
	}
		
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
	throws ParseException{
		
		Optional<Resolucion> objResolucion = rService.buscarId(id);
		
		if(objResolucion == null)
		{
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/resolucion/listar";
		}
		else 
		{
			model.addAttribute("listaCasos", cService.listar());
			
			if (objResolucion.isPresent())
				objResolucion.ifPresent(o -> model.addAttribute("resolucion", o));
			
			return "resolucion";
		}		
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object>model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0)
			{
				rService.eliminar(id);
				model.put("listaResoluciones", rService.listar());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaResoluciones", rService.listar());
		}
		return "listResolucion";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaResoluciones", rService.listar());
		return "listResolucion";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object>model, @ModelAttribute Resolucion resolucion)
	throws ParseException{
		rService.listarId(resolucion.getIdResol());
		return "listResolucion";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object>model, @ModelAttribute Resolucion resolucion)
	throws ParseException{
		List<Resolucion> listaResoluciones;
		resolucion.setDescripcion(resolucion.getDescripcion());
		listaResoluciones = rService.buscarDescripcion(resolucion.getDescripcion());
		
		if(listaResoluciones.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaResoluciones", listaResoluciones);
		return "buscar";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("resolucion",new Resolucion());
		return "buscar";
	}
}