package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cibertec.entity.Autor;
import com.cibertec.entity.Genero;
import com.cibertec.entity.Libro;
import com.cibertec.repository.AutorRepository;
import com.cibertec.repository.GeneroRepository;
import com.cibertec.repository.LibroRepository;

@Controller
@RequestMapping("/libro")
public class LibroController {
	
	@Autowired
	private LibroRepository librorepo;
	
	@Autowired
	private AutorRepository autorrepo;
	
	@Autowired
	private GeneroRepository generorepo;
	
	@GetMapping("/consulta")
	public String consulta(Model model) {
		List<Libro> lstLibros = librorepo.findAll();
		List<Autor> lstAutores = autorrepo.findAll();
		
		model.addAttribute("lstlibros", lstLibros);
		model.addAttribute("lstautores", lstAutores);
		return "consulta-vivanco";
	}
	
	@PostMapping("/consulta")
	public String postConsulta(@RequestParam("autor") int autor, Model model) {
		List<Libro> lstLibros = librorepo.findAllByIdautor(autor);
		List<Autor> lstAutores = autorrepo.findAll();
		
		if(autor == -1) {
			model.addAttribute("lstlibros", librorepo.findAll());
		}else {
			model.addAttribute("lstlibros", lstLibros);
		}
		
		model.addAttribute("lstautores", lstAutores);
		return "consulta-vivanco";
	}
	
	@GetMapping("/eliminar")
	public String getLibro(@RequestParam("id") String id, Model model) {
		Libro libro = librorepo.getById(id);
		List<Autor> lstAutores = autorrepo.findAll();
		List<Genero> lstGeneros = generorepo.findAll();
		
		model.addAttribute("libro", libro);
		model.addAttribute("lstgeneros", lstGeneros);
		model.addAttribute("lstautores", lstAutores);
		return "mantenimiento-vivanco";
	}
	
	@PostMapping("/eliminar")
	public String deleteLibro(@ModelAttribute(name = "libro") Libro libro, Model model) {
		try {
			librorepo.delete(libro);
			model.addAttribute("clase", "success");
			model.addAttribute("message", "Eliminado con exito!");
		} catch (Exception e) {
			model.addAttribute("clase", "danger");
			model.addAttribute("message", "Error al registrar");
		}
		return "mantenimiento-vivanco";
	}
}
