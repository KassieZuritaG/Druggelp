package com.ortizzurita.druggelp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ortizzurita.druggelp.models.entities.Farmacia;
import com.ortizzurita.druggelp.models.services.IFarmaciaService;

@Controller
@RequestMapping(value="/farmacia")
public class FarmaciaController {

	@Autowired 
	private IFarmaciaService srvFarmacia;
	
	@GetMapping(value="/create") 
	public String create(Model model) {
		Farmacia farmacia=new Farmacia();
		model.addAttribute("title", "Registro de nuevo Farmacia");
		model.addAttribute("farmacia", farmacia);
		return "farmacia/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Farmacia farmacia = srvFarmacia.findById(id);
		model.addAttribute("farmacia", farmacia);				
		return "farmacia/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Farmacia farmacia = srvFarmacia.findById(id);
		model.addAttribute("farmacia", farmacia);
		model.addAttribute("title", "Actualizando el registro de " + farmacia);
		return "farmacia/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvFarmacia.delete(id);
		return "redirect:/farmacia/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Farmacia> farmacias = srvFarmacia.findAll();
		model.addAttribute("farmacias", farmacias);
		model.addAttribute("title", "Listado de Farmacias");
		return "farmacia/list";
	}
	
	@PostMapping(value="/save") 
	public String save(Farmacia farmacia, Model model) {
		srvFarmacia.save(farmacia);
		return "redirect:/farmacia/list";
	}
	
}
