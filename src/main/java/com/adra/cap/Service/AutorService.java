package com.adra.cap.Service;

import java.util.List;
import com.adra.cap.Entity.Autor;

public interface AutorService {
	Autor insertarAutor (Autor a);
	List<Autor> listarAutor();
	Autor buscarAutor(int idautor);
	void eliminarAutor(int idautor);
	Autor actualizarAutor(Autor a);
}
