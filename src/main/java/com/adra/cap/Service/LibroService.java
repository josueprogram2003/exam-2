package com.adra.cap.Service;

import java.util.List;
import com.adra.cap.Entity.Libro;

public interface LibroService {
	Libro insertarLibro (Libro l);
	List<Libro> listarLibro();
	Libro buscarLibro(int idlibro);
	void eliminarLibro(int idlibro);
	Libro actualizarLibro(Libro l);
}
