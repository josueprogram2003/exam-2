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
import com.adra.cap.Entity.Editorial;
import com.adra.cap.ServiceImpl.EditorialServiceImpl;

@RestController
@RequestMapping("api/editorial")
public class EditorialController {
	@Autowired
	private EditorialServiceImpl esi;
	
	@PostMapping("/save")
	public ResponseEntity<Editorial> save(@RequestBody Editorial a){
		try {
			Editorial e = esi.insertarEditorial(a);
			return new ResponseEntity<>(e,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Editorial>> getEditorial(){
		try {
			List<Editorial> list = new ArrayList<>();
			list=esi.listarEditorial();
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
	public ResponseEntity<Editorial> getEditorialID(@PathVariable("id") int id){
		Editorial e = esi.buscarEditorial(id);
		if (e.getIdeditorial()>0) {
			return new ResponseEntity<>(e,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/delete/{id}")
		public ResponseEntity<HttpStatus> delete(@PathVariable("id")int id){
			try {
				esi.eliminarEditorial(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Editorial> update(@RequestBody Editorial a, @PathVariable("id") int id){
		try {
			System.out.println("Hola");
			Editorial ul = esi.buscarEditorial(id);
			if(ul.getIdeditorial()>0) {
				ul.setNombre(a.getNombre());
				return new ResponseEntity<>(esi.actualizarEditorial(ul),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
