package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.entity.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {
	
}
