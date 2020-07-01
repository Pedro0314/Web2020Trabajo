package pe.edu.upc.spring.controller;

import java.text.ParseException;
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

import pe.edu.upc.spring.model.Detalle;
import pe.edu.upc.spring.service.IDetalleService;

@Controller
@RequestMapping("/detalle")
public class DetalleController {

	@Autowired
	private IDetalleService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoDetalles(Map<String, Object> model) {
		model.put("listaDetalles", rService.listar());
		return "listDetalle";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("detalle", new Detalle());
		return "detalle";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Detalle objDetalle, BindingResult binRes, Model model)
	throws ParseException
	{
		if (binRes.hasErrors())
			return "detalle";
		else 
		{
			boolean flag = rService.insertar(objDetalle);
			if (flag) {
				return "redirect:/detalle/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/detalle/irRegistrar";
			}
		}
	}
	

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
	throws ParseException
	{
		Optional<Detalle> objDetalle = rService.listarId(id);
		if (objDetalle == null ) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un roche");
			return "redirect:/Detalle/listar";
		}
		else {
			model.addAttribute("detalle", objDetalle);
			return "detalle";
		}
	}
	
	/*
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid Race objRace, BindingResult binRes, Model model,
			RedirectAttributes objRedir)
	throws ParseException
	{
		if (binRes.hasErrors()) {
			return "redirect:/race/listar";
		}
		else {
			boolean flag = rService.modificar(objRace);
			if (flag) {
				objRedir.addFlashAttribute("mensaje","Se actualizo correctamente");
				return "redirect:/race/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/race/irRegistrar";
			}
		}
	}
	*/
	
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				rService.eliminar(id);
				model.put("listaDetalles", rService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaDetalles", rService.listar());
		}
		return "listDetalle";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaDetalles", rService.listar());
		return "listDetalle";
	}
	
	
}
