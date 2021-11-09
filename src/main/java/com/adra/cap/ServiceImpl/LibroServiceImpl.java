package com.adra.cap.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adra.cap.Entity.Libro;
import com.adra.cap.Repository.LibroRepository;
import com.adra.cap.Service.LibroService;
@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	private LibroRepository lr;
	
	@Override
	public Libro insertarLibro(Libro l) {
		// TODO Auto-generated method stub
		return lr.save(l);
	}

	@Override
	public List<Libro> listarLibro() {
		// TODO Auto-generated method stub
		return lr.findAll();
	}

	@Override
	public Libro buscarLibro(int idlibro) {
		// TODO Auto-generated method stub
		return lr.findById(idlibro).get();
	}

	@Override
	public void eliminarLibro(int idlibro) {
		// TODO Auto-generated method stub
		lr.deleteById(idlibro);
	}

	@Override
	public Libro actualizarLibro(Libro l) {
		// TODO Auto-generated method stub
		return lr.save(l);
	}

}
