package com.demo.backend.organizaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.backend.organizaciones.entity.TblOrganizaciones;

@Repository
public interface OrganizacionesRepository extends JpaRepository<TblOrganizaciones, Long>{
	
	@Query("SELECT TO FROM TblOrganizaciones TO ORDER BY TO.id DESC ")	
	List<TblOrganizaciones> findOrganizacionesById();

}
