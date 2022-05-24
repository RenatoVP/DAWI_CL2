package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.entity.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, String>{
	public List<Libro> findAllByIdautor(int idautor);
}
