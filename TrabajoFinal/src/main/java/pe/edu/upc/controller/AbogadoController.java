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

import pe.edu.upc.model.Especialidad;
import pe.edu.upc.model.Abogado;


import pe.edu.upc.service.IEspecialidadService;
import pe.edu.upc.service.IAbogadoService;

@Controller
@RequestMapping("/abogado")
public class AbogadoController {
	
	@Autowired
	private IAbogadoService aService;
	
	@Autowired
	private IEspecialidadService eService;
	
	
		
	@RequestMapping("/")
	public String irPaginaListadoAbogados(Map<String, Object> model) {
		model.put("listaAbogados", aService.listar());
		return "listAbogados";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroAbogados(Model model) {
		model.addAttribute("listaEspecialidades", eService.listar());
		model.addAttribute("abogado", new Abogado());
		model.addAttribute("especialidad", new Especialidad());
		return "abogado";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Abogado objAbogado, BindingResult binRes, Model model)
	throws ParseException{
		if(binRes.hasErrors()) 
		{
			model.addAttribute("listaEspecialidades", eService.listar());					
			return "abogado";
		}
		else
		{
			boolean flag = aService.insertar(objAbogado);
			if(flag) {
				return "redirect:/abogado/listar";
			}
			else {
				model.addAttribute("mensaje ", "Ocurrió un roche");
				return "redirect:/abogado/irRegistrar";
			}
		}
	}
		
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
	throws ParseException{
		
		Optional<Abogado> objAbogado = aService.buscarId(id);
		
		if(objAbogado == null)
		{
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/abogado/listar";
		}
		else 
		{
			model.addAttribute("listaEspecialidades", eService.listar());
			
			if (objAbogado.isPresent())
				objAbogado.ifPresent(o -> model.addAttribute("abogado", o));
			
			return "abogado";
		}		
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object>model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0)
			{
				aService.eliminar(id);
				model.put("listaAbogados", aService.listar());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaAbogados", aService.listar());
		}
		return "listAbogados";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaAbogados", aService.listar());
		return "listAbogados";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object>model, @ModelAttribute Abogado abogado)
	throws ParseException{
		aService.listarId(abogado.getIdAbogado());
		return "listAbogados";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object>model, @ModelAttribute Abogado abogado)
	throws ParseException{
		List<Abogado> listaAbogados;
		abogado.setNameAbogado(abogado.getNameAbogado());
		listaAbogados = aService.buscarNombre(abogado.getNameAbogado());
		
		if(listaAbogados.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaAbogados", listaAbogados);
		return "buscar";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("abogado",new Abogado());
		return "buscar";
	}
}