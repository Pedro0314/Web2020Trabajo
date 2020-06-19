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

import pe.edu.upc.model.Abogado;
import pe.edu.upc.model.Caso;
import pe.edu.upc.model.RegistroCaso;

import pe.edu.upc.service.IAbogadoService;
import pe.edu.upc.service.ICasoService;
import pe.edu.upc.service.IRegistroCasoService;

@Controller
@RequestMapping("/RegistroCaso")
public class RegistroCasoController {
	
	@Autowired
	private IRegistroCasoService rService;
	
	@Autowired
	private ICasoService cService;
	
	@Autowired
	private IAbogadoService aService;
		
	@RequestMapping("/")
	public String irPaginaListadoMascotas(Map<String, Object> model) {
		model.put("listaRegistroCasos", rService.listar());
		return "listRegistroCasos";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroMascotas(Model model) {
		model.addAttribute("listaCasos", cService.listar());
		model.addAttribute("listaAbogados", aService.listar());		
		model.addAttribute("abogado", new Abogado());
		model.addAttribute("registroCaso", new RegistroCaso());
		model.addAttribute("caso", new Caso());
		return "eegistroCaso";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid RegistroCaso objRegistroCaso, BindingResult binRes, Model model)
	throws ParseException{
		if(binRes.hasErrors()) 
		{
			model.addAttribute("listaCasos", cService.listar());
			model.addAttribute("listaAbogados", aService.listar());					
			return "registroCaso";
		}
		else
		{
			boolean flag = rService.insertar(objRegistroCaso);
			if(flag) {
				return "redirect:/egistroCaso/listar";
			}
			else {
				model.addAttribute("mensaje ", "Ocurrió un roche");
				return "redirect:/registroCaso/irRegistrar";
			}
		}
	}
		
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
	throws ParseException{
		
		Optional<RegistroCaso> objRegistroCaso = rService.buscarId(id);
		
		if(objRegistroCaso == null)
		{
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/registroCaso/listar";
		}
		else 
		{
			model.addAttribute("listaCasos", cService.listar());
			model.addAttribute("listaAbogados", aService.listar());
			
			if (objRegistroCaso.isPresent())
				objRegistroCaso.ifPresent(o -> model.addAttribute("registroCaso", o));
			
			return "registroCaso";
		}		
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object>model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0)
			{
				rService.eliminar(id);
				model.put("listaRegistroCasos", rService.listar());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaRegistroCasos", rService.listar());
		}
		return "listRegistroCasos";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaRegistroCasos", rService.listar());
		return "listRegistroCasos";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object>model, @ModelAttribute RegistroCaso registroCaso)
	throws ParseException{
		rService.listarId(registroCaso.getIdRegistroCaso());
		return "listRegistroCasos";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object>model, @ModelAttribute RegistroCaso registroCaso)
	throws ParseException{
		List<RegistroCaso> listaRegistroCasos;
		registroCaso.setDescripRegistroCaso(registroCaso.getDescripRegistroCaso());
		listaRegistroCasos = rService.buscarNombre(registroCaso.getDescripRegistroCaso());
		
		if(listaRegistroCasos.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaRegistroCasos", listaRegistroCasos);
		return "buscar";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("registroCaso",new RegistroCaso());
		return "buscar";
	}
}