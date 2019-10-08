package com.demo.backend.organizaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.backend.organizaciones.entity.TblConsecutivos;

@Repository
public interface ConsecutivosRepository extends JpaRepository<TblConsecutivos, Long>{

}
