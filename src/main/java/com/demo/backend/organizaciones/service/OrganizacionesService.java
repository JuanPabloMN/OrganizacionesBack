package com.demo.backend.organizaciones.service;

import java.util.List;

import com.demo.backend.organizaciones.OrganizacionesDTO;
import com.demo.backend.organizaciones.entity.TblOrganizaciones;

public interface OrganizacionesService {
	public List<TblOrganizaciones>findAll();
	public OrganizacionesDTO InsertOrganizaciones(OrganizacionesDTO organizacionesDTO);
	public OrganizacionesDTO updateOrganizaciones(OrganizacionesDTO organizacionesDTO);
	public OrganizacionesDTO deleteOrganizaciones(OrganizacionesDTO organizacionesDTO);

}
