package com.adra.cap.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adra.cap.Entity.Autor;
import com.adra.cap.Repository.AutorRepository;
import com.adra.cap.Service.AutorService;
@Service
public class AutorServiceImpl implements AutorService{

	@Autowired
	private AutorRepository ar;
	
	@Override
	public Autor insertarAutor(Autor a) {
		// TODO Auto-generated method stub
		return ar.save(a);
	}

	@Override
	public List<Autor> listarAutor() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

	@Override
	public Autor buscarAutor(int idautor) {
		// TODO Auto-generated method stub
		return ar.findById(idautor).get();
	}

	@Override
	public void eliminarAutor(int idautor) {
		// TODO Auto-generated method stub
		ar.deleteById(idautor);
	}

	@Override
	public Autor actualizarAutor(Autor a) {
		// TODO Auto-generated method stub
		return ar.save(a);
	}

}
