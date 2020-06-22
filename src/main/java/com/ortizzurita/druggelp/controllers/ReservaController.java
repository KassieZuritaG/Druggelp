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
import com.ortizzurita.druggelp.models.entities.Reserva;
import com.ortizzurita.druggelp.models.services.IClienteService;
import com.ortizzurita.druggelp.models.services.IReservaService;

@Controller
@RequestMapping(value="/reserva")
public class ReservaController {

	@Autowired 
	private IReservaService srvReserva;
	
	@Autowired 
	private IClienteService srvCliente;
	
	@GetMapping(value="/create") 
	public String create(Model model) {
		Reserva reserva=new Reserva();
		model.addAttribute("title", "Registro de nuevo Reserva");
		model.addAttribute("reserva", reserva);
		List<Cliente> clientes = srvCliente.findAll();
		model.addAttribute("clientes", clientes);
		return "reserva/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Reserva reserva = srvReserva.findById(id);
		model.addAttribute("reserva", reserva);				
		return "reserva/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Reserva reserva = srvReserva.findById(id);
		model.addAttribute("reserva", reserva);
		model.addAttribute("title", "Actualizando el registro de " + reserva);
		List<Cliente> clientes = srvCliente.findAll();
		model.addAttribute("clientes", clientes);
		return "reserva/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		srvReserva.delete(id);
		return "redirect:/reserva/list";		
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Reserva> reservas = srvReserva.findAll();
		model.addAttribute("reservas", reservas);
		model.addAttribute("title", "Listado de Reservas");
		return "reserva/list";
	}
	
	@PostMapping(value="/save") 
	public String save(Reserva reserva, Model model) {
		srvReserva.save(reserva);
		return "redirect:/reserva/list";
	}
	
}
