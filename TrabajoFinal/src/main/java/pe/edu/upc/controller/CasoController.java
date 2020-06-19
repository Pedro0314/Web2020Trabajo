package pe.edu.upc.controller;

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

import pe.edu.upc.model.Caso;
import pe.edu.upc.service.ICasoService;

@Controller
@RequestMapping("/caso")
public class CasoController {

	@Autowired
	private ICasoService cService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoRazas(Map<String, Object> model) {
		model.put("listaCasos", cService.listar());
		return "listCaso";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("caso", new Caso());
		return "caso";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Caso objCaso, BindingResult binRes, Model model)
	throws ParseException
	{
		if (binRes.hasErrors())
			return "caso";
		else 
		{
			boolean flag = cService.insertar(objCaso);
			if (flag) {
				return "redirect:/caso/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/caso/irRegistrar";
			}
		}
	}
	

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
	throws ParseException
	{
		Optional<Caso> objCaso = cService.listarId(id);
		if (objCaso == null ) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un roche");
			return "redirect:/caso/listar";
		}
		else {
			model.addAttribute("caso", objCaso);
			return "Caso";
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
				cService.eliminar(id);
				model.put("listaCasos", cService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un roche");
			model.put("listaCasos", cService.listar());
		}
		return "listCaso";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaCasos", cService.listar());
		return "listCaso";
	}
	
	
}
