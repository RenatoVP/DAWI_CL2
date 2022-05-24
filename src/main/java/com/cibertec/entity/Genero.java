package com.cibertec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "genero")
@Data
public class Genero {
	@Id
	@Column(name = "codigo")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
}
