package com.demo.backend.organizaciones.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TBL_ORGANIZACIONES")
public class TblOrganizaciones implements Serializable{

	private static final long serialVersionUID = -8874795557175221139L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="idexterno")
	private String idExterno;
	private String nombre;
	private String direccion;
	private String telefono;
}
