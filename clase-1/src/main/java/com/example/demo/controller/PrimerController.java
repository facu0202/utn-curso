package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Vehiculo;

@Controller
public class PrimerController {

	List<Vehiculo> vehiculos = new ArrayList<>();
	
	
	private void init()
	{
		vehiculos.add(new Vehiculo("1", "BMW", "Dorado"));
		vehiculos.add(new Vehiculo("2", "Audi", "Rojo fuego"));
		vehiculos.add(new Vehiculo("3", "Ferrari", "Amarilla"));
	}
	
	@RequestMapping(value = "/vehiculos", method = RequestMethod.GET)
	@ResponseBody
	public List<Vehiculo> vehiculos()
	{
		init();
		return vehiculos;
	}
	
	@RequestMapping(value = "/vehiculos/{1}", method = RequestMethod.GET)
	@ResponseBody
	public Vehiculo getVehiculo()
	{
		init();
		return vehiculos.get(0);
	}
	
	@RequestMapping(value = "/vehiculos", method = RequestMethod.POST)
	@ResponseBody
	public String postVehiculo(@RequestBody Vehiculo v)
	{
		vehiculos.add(v);
		return "OK";
	}
	
	@RequestMapping(value = "/vehiculos/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteVehiculo(@PathVariable String id )
	{
		Iterator<Vehiculo> xit = vehiculos.iterator();
		while (xit.hasNext())
		{
			Vehiculo v = xit.next();
			if (v.getPatente().equals(id))
			{
				xit.remove();
				break;
			}
		}
		return "OK";
	}
	
	@RequestMapping(value = "/hola", method = RequestMethod.GET)
	@ResponseBody
	public String hola( )
	{
		return "hola ";
	}
	
	

}
