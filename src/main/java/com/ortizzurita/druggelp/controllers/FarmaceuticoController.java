package com.ortizzurita.druggelp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ortizzurita.druggelp.models.entities.Farmaceutico;
import com.ortizzurita.druggelp.models.services.IFarmaceuticoService;

@Controller
@RequestMapping(value="/farmaceutico")
public class FarmaceuticoController {

	@Autowired 
	private IFarmaceuticoService srvFarmaceutico;
	
	@GetMapping(value="/create") 
	public String create(Model model) {
		Farmaceutico farmaceutico=new Farmaceutico();
		model.addAttribute("title", "Registro de nuevo Farmaceutico");
		model.addAttribute("farmaceutico", farmaceutico);
		return "farmaceutico/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Farmaceutico farmaceutico = srvFarmaceutico.findById(id);
		model.addAttribute("farmaceutico", farmaceutico);				
		return "farmaceutico/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Farmaceutico farmaceutico = srvFarmaceutico.findById(id);
		model.addAttribute("farmaceutico", farmaceutico);
		model.addAttribute("title", "Actualizando el registro de " + farmaceutico);
		return "farmaceutico/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvFarmaceutico.delete(id);
		return "redirect:/farmaceutico/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Farmaceutico> farmaceuticos = srvFarmaceutico.findAll();
		model.addAttribute("farmaceuticos", farmaceuticos);
		model.addAttribute("title", "Listado de Farmaceuticos");
		return "farmaceutico/list";
	}
	
	@PostMapping(value="/save") 
	public String save(Farmaceutico farmaceutico, Model model) {
		srvFarmaceutico.save(farmaceutico);
		return "redirect:/farmaceutico/list";
	}
}
