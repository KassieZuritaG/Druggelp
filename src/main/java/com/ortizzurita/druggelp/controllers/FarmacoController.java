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
import com.ortizzurita.druggelp.models.entities.Farmacia;
import com.ortizzurita.druggelp.models.entities.Farmaco;
import com.ortizzurita.druggelp.models.entities.Reserva;
import com.ortizzurita.druggelp.models.services.IFarmaciaService;
import com.ortizzurita.druggelp.models.services.IFarmacoService;
import com.ortizzurita.druggelp.models.services.IReservaService;

@Controller
@RequestMapping(value="/farmaco")
public class FarmacoController {

	@Autowired 
	private IFarmacoService srvFarmaco;
	
	@Autowired 
	private IFarmaciaService srvFarmacia;
	
	@Autowired 
	private IReservaService srvReserva;
	
	@GetMapping(value="/create") 
	public String create(Model model) {
		Farmaco farmaco=new Farmaco();
		model.addAttribute("title", "Registro de nuevo Farmaco");
		model.addAttribute("farmaco", farmaco);
		List<Farmacia> farmacias = srvFarmacia.findAll();
		model.addAttribute("farmacia",farmacias);
		List<Reserva> reservas = srvReserva.findAll();
		model.addAttribute("reserva",reservas);
		return "farmaco/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Farmaco farmaco = srvFarmaco.findById(id);
		model.addAttribute("farmaco", farmaco);				
		return "farmaco/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Farmaco farmaco = srvFarmaco.findById(id);
		model.addAttribute("farmaco", farmaco);
		model.addAttribute("title", "Actualizando el registro de " + farmaco);
		List<Farmacia> farmacias = srvFarmacia.findAll();
		model.addAttribute("farmacia",farmacias);
		List<Reserva> reservas = srvReserva.findAll();
		model.addAttribute("reserva",reservas);
		return "farmaco/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvFarmaco.delete(id);
		return "redirect:/farmaco/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Farmaco> farmacos = srvFarmaco.findAll();
		model.addAttribute("farmacos", farmacos);
		model.addAttribute("title", "Listado de Farmacos");
		return "farmaco/list";
	}
	
	@PostMapping(value="/save") 
	public String save(Farmaco farmaco, Model model) {
		srvFarmaco.save(farmaco);
		return "redirect:/farmaco/list";
	}
}
