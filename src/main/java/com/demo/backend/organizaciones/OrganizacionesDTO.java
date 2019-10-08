package com.demo.backend.organizaciones;

import lombok.Data;

@Data
public class OrganizacionesDTO {
	private String idExterno;
	private String nombre;
	private String direccion;
	private String telefono;
	private Long id;
}
