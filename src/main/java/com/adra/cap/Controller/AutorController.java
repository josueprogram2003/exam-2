package com.adra.cap.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.adra.cap.Entity.Autor;
import com.adra.cap.ServiceImpl.AutorServiceImpl;

@RestController
@RequestMapping("api/autor")
public class AutorController {
	
	
	@Autowired
	private AutorServiceImpl asi;
	
	@PostMapping("/save")
	public ResponseEntity<Autor> save(@RequestBody Autor a){
		try {
			Autor autor = asi.insertarAutor(a);
			return new ResponseEntity<>(autor,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Autor>> getAutor(){
		try {
			List<Autor> list = new ArrayList<>();
			list=asi.listarAutor();
			System.out.println("Pase");
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Autor> getAutorID(@PathVariable("id") int id){
		Autor a = asi.buscarAutor(id);
		if (a.getIdautor()>0) {
			return new ResponseEntity<>(a,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/delete/{id}")
		public ResponseEntity<HttpStatus> delete(@PathVariable("id")int id){
			try {
				asi.eliminarAutor(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Autor> update(@RequestBody Autor a, @PathVariable("id") int id){
		try {
			System.out.println("Hola");
			Autor ul = asi.buscarAutor(id);
			if(ul.getIdautor()>0) {
				ul.setNombres(a.getNombres());
				ul.setApellidos(a.getApellidos());
				return new ResponseEntity<>(asi.actualizarAutor(ul),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
