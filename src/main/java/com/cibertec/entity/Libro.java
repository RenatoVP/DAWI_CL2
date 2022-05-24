package com.cibertec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "libro")
@Data
public class Libro {
	@Id
	@Column(name = "codigo")
	private String id;
	private String titulo;
	private String serie;
	private String editorial;
	private String idioma;
	private String fecpublicacion;
	@Column(name = "cod_autor")
	private int id_autor;
	
	@ManyToOne
	@JoinColumn(name = "cod_autor", insertable = false, updatable = false)
	private Autor autor;
	
	@Column(name = "cod_genero")
	private int id_genero;
	
	@ManyToOne
	@JoinColumn(name = "cod_genero", insertable = false, updatable = false)
	private Genero genero;
	private int estado;
}
