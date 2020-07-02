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
import pe.edu.upc.spring.service.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private IClienteService cService;
	
	@RequestMapping("/bienvenido")
	public String irDuenoBienvenido() {
		
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irDueno(Map<String, Object>model) {
		model.put("listaClientes", cService.listar());
		return "listDueno";
	}
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "cliente";
		
		
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Cliente objCliente, BindingResult binRes, Model model)
	throws ParseException{
		if(binRes.hasErrors())
			return "cliente";
		else{
			boolean flag=cService.insertar(objCliente);
			if(flag) {
				return "redirect:/cliente/listar";
			}
			else {
				model.addAttribute("mensaje ", "Ocurrió un error");
				return "redirect:/cliente/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid Cliente objCliente, BindingResult binRes, Model model, RedirectAttributes objRedir)
	throws ParseException{
		if(binRes.hasErrors())
			return "redirect:/cliente/listar";
		else{
			boolean flag=cService.modificar(objCliente);
			if(flag) {
				objRedir.addFlashAttribute("mensaje","Se actualizó correctamente");
				return "redirect:/cliente/listar";
			}
			else
			{
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/cliente/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
	throws ParseException{
		Optional<Cliente>objCliente=cService.buscarId(id);
		if(objCliente==null)
		{
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/cliente/listar";
		}
		else {
			model.addAttribute("cliente",objCliente);
			return "cliente";
		}
		
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object>model, @RequestParam(value="id")Integer id) {
		try {
			if(id!=null&&id>0)
			{
				cService.eliminar(id);
				model.put("listaClientes", cService.listar());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaClientes", cService.listar());
		}
		return "listCliente";
	}
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaClientes", cService.listar());
		return "listCliente";
	}
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object>model, @ModelAttribute Cliente Cliente)
	throws ParseException{
		cService.listarId(Cliente.getIdCliente());
		return "listCliente";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object>model, @ModelAttribute Cliente Cliente)
	throws ParseException{
		List<Cliente>listaClientes;
		Cliente.setDomicilioLegal(Cliente.getDomicilioLegal());
		listaClientes=cService.buscarDomicilio(Cliente.getDomicilioLegal());
		
		if(listaClientes.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaClientes", listaClientes);
		return "buscar";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("dueno",new Cliente());
		return "buscar";
	}
	
}
