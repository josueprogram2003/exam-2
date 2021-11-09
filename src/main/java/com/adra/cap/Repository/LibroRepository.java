package com.adra.cap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adra.cap.Entity.Libro;
@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{

}
