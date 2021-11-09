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
import com.adra.cap.Entity.Libro;
import com.adra.cap.ServiceImpl.LibroServiceImpl;

@RestController
@RequestMapping("api/libro")
public class LibroController {
	
	
	@Autowired
	private LibroServiceImpl lsi;
	
	@PostMapping("/save")
	public ResponseEntity<Libro> save(@RequestBody Libro a){
		try {
			Libro l = lsi.insertarLibro(a);
			return new ResponseEntity<>(l,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Libro>> getLibro(){
		try {
			List<Libro> list = new ArrayList<>();
			list=lsi.listarLibro();
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
	public ResponseEntity<Libro> getID(@PathVariable("id") int id){
		Libro a = lsi.buscarLibro(id);
		if (a.getIdlibro()>0) {
			return new ResponseEntity<>(a,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/delete/{id}")
		public ResponseEntity<HttpStatus> delete(@PathVariable("id")int id){
			try {
				lsi.eliminarLibro(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Libro> update(@RequestBody Libro a, @PathVariable("id") int id){
		try {
			System.out.println("Hola");
			Libro ul =lsi.buscarLibro(id);
			if(ul.getIdlibro()>0) {
				ul.setTitulo(a.getTitulo());
				ul.setPaginas(a.getPaginas());
				ul.setDescripcion(a.getDescripcion());
				ul.setAutor(a.getAutor());
				ul.setEditorial(a.getEditorial());
				return new ResponseEntity<>(lsi.actualizarLibro(ul),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
