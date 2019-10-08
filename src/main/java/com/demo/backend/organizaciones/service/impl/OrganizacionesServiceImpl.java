package com.demo.backend.organizaciones.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.backend.organizaciones.OrganizacionesDTO;
import com.demo.backend.organizaciones.entity.TblConsecutivos;
import com.demo.backend.organizaciones.entity.TblOrganizaciones;
import com.demo.backend.organizaciones.repository.ConsecutivosRepository;
import com.demo.backend.organizaciones.repository.OrganizacionesRepository;
import com.demo.backend.organizaciones.service.OrganizacionesService;

@Service
public class OrganizacionesServiceImpl implements OrganizacionesService{

	@Autowired OrganizacionesRepository organizacionesRepository; 
	@Autowired ConsecutivosRepository consecutivosRepository;
	
	@Override
	public List<TblOrganizaciones> findAll() {
		List<TblOrganizaciones> lstOrganizaciones = organizacionesRepository.findAll();
		return lstOrganizaciones;
	}

	@Override
	@Transactional
	public OrganizacionesDTO InsertOrganizaciones(OrganizacionesDTO organizacionesDTO) {
		
		TblConsecutivos consecutivos = new TblConsecutivos();
		consecutivosRepository.saveAndFlush(consecutivos);
		
		TblOrganizaciones organizaciones = new TblOrganizaciones();
		String consecutivoS = null;

			if(consecutivos.getId() <10)
				consecutivoS = "00" + consecutivos.getId();
			if(consecutivos.getId() >= 10 && consecutivos.getId() <100)
				consecutivoS = "0" + consecutivos.getId();

		
		String idExterno = organizacionesDTO.getNombre().substring(0, 4) + (organizacionesDTO.getTelefono().substring((organizacionesDTO.getTelefono().length()-4), 
				(organizacionesDTO.getTelefono().length()))) + "NE" + consecutivoS;
		
		organizaciones.setIdExterno(idExterno);
		organizaciones.setNombre(organizacionesDTO.getNombre());
		organizaciones.setTelefono(organizacionesDTO.getTelefono());
		organizaciones.setDireccion(organizacionesDTO.getDireccion());
		
		organizacionesRepository.saveAndFlush(organizaciones);
		organizacionesDTO.setId(organizaciones.getId());
		organizacionesDTO.setIdExterno(organizaciones.getIdExterno());
		return organizacionesDTO;
	}

	@Override
	@Transactional
	public OrganizacionesDTO updateOrganizaciones(OrganizacionesDTO organizacionesDTO) {
		
		TblOrganizaciones organizacion = organizacionesRepository.findById(organizacionesDTO.getId()).get();
		
		String idExterno = organizacionesDTO.getNombre().substring(0, 3) + (organizacionesDTO.getTelefono().substring((organizacionesDTO.getTelefono().length()-4),
		(organizacionesDTO.getTelefono().length()))) + "NE" + organizacion.getIdExterno().substring(organizacion.getIdExterno().length()-3, organizacion.getIdExterno().length());
		
		organizacion.setNombre(organizacionesDTO.getNombre());
		organizacion.setDireccion(organizacionesDTO.getDireccion());
		organizacion.setTelefono(organizacionesDTO.getTelefono());
		organizacion.setIdExterno(idExterno);
		
		organizacionesRepository.saveAndFlush(organizacion);

		organizacionesDTO.setId(organizacion.getId());
		organizacionesDTO.setIdExterno(organizacion.getIdExterno());
		return organizacionesDTO;
	}

	@Override
	public OrganizacionesDTO deleteOrganizaciones(OrganizacionesDTO organizacionesDTO) {
		TblOrganizaciones organizacion = organizacionesRepository.findById(organizacionesDTO.getId()).get();
		
		organizacionesRepository.deleteById(organizacion.getId());
		return organizacionesDTO;
	}
}
