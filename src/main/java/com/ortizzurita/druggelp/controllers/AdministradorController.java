package com.ortizzurita.druggelp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ortizzurita.druggelp.models.entities.Administrador;
import com.ortizzurita.druggelp.models.services.IAdministradorService;

@Controller
@RequestMapping(value="/administrador") 
public class AdministradorController {

	@Autowired 
	private IAdministradorService srvAdministrador;
	
	@GetMapping(value="/create") 
	public String create(Model model) {
		Administrador administrador=new Administrador();
		model.addAttribute("title", "Registro de nuevo Administrador");
		model.addAttribute("administrador", administrador);
		return "administrador/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Administrador administrador = srvAdministrador.findById(id);
		model.addAttribute("administrador", administrador);				
		return "administrador/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Administrador administrador = srvAdministrador.findById(id);
		model.addAttribute("administrador", administrador);
		model.addAttribute("title", "Actualizando el registro de " + administrador);
		return "administrador/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvAdministrador.delete(id);
		return "redirect:/administrador/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Administrador> administradores = srvAdministrador.findAll();
		model.addAttribute("administradores", administradores);
		model.addAttribute("title", "Listado de administradores");
		return "administrador/list";
	}
	
	@PostMapping(value="/save") 
	public String save(Administrador administrador, Model model) {
		srvAdministrador.save(administrador);
		return "redirect:/administrador/list";
	}
}
