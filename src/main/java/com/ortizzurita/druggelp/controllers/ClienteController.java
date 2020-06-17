package com.ortizzurita.druggelp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ortizzurita.druggelp.models.entities.Cliente;
import com.ortizzurita.druggelp.models.services.IClienteService;

@Controller
@RequestMapping(value="/cliente") 
public class ClienteController {
	@Autowired 
	private  IClienteService srvCliente;
	
	@GetMapping(value="/create") 
	public String create(Model model) {
		Cliente cliente=new Cliente();
		model.addAttribute("title", "Registro de nuevo Cliente");
		model.addAttribute("cliente", cliente);
		return "cliente/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Cliente cliente = srvCliente.findById(id);
		model.addAttribute("cliente", cliente);				
		return "cliente/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Cliente cliente = srvCliente.findById(id);
		model.addAttribute("cliente", cliente);
		model.addAttribute("title", "Actualizando el registro de " + cliente);
		return "cliente/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvCliente.delete(id);
		return "redirect:/cliente/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Cliente> clientes = srvCliente.findAll();
		model.addAttribute("clientes", clientes);
		model.addAttribute("title", "Listado de Clientes");
		return "cliente/list";
	}
	
	@PostMapping(value="/save") 
	public String save(Cliente cliente, Model model) {
		srvCliente.save(cliente);
		return "redirect:/cliente/list";
	}
}
