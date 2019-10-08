package com.demo.backend.organizaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.backend.organizaciones.OrganizacionesDTO;
import com.demo.backend.organizaciones.entity.TblOrganizaciones;
import com.demo.backend.organizaciones.service.OrganizacionesService;

@RestController
@RequestMapping("/api")
public class OrganizacionesController {
	@Autowired OrganizacionesService service;
	
	@GetMapping("/Organizaciones")
	public List<TblOrganizaciones> index(){
		return service.findAll();
		
	}
	
	@PostMapping("/insert")
	@ResponseStatus(HttpStatus.CREATED)
	public OrganizacionesDTO insert(@RequestBody OrganizacionesDTO organizacionesDTO) {
		return service.InsertOrganizaciones(organizacionesDTO);
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public OrganizacionesDTO update(@RequestBody OrganizacionesDTO organizacionesDTO) {
		return service.updateOrganizaciones(organizacionesDTO);
	}
	
	@PostMapping("/delete")
	@ResponseStatus(HttpStatus.CREATED)
	public OrganizacionesDTO delete(@RequestBody OrganizacionesDTO organizacionesDTO) {
		return service.deleteOrganizaciones(organizacionesDTO);
	}

}
