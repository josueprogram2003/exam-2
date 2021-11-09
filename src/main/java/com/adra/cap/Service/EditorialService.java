package com.adra.cap.Service;

import java.util.List;
import com.adra.cap.Entity.Editorial;

public interface EditorialService {
	Editorial insertarEditorial (Editorial e);
	List<Editorial> listarEditorial();
	Editorial buscarEditorial(int ideditorial);
	void eliminarEditorial(int ideditorial);
	Editorial actualizarEditorial(Editorial e);
}
