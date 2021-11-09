package com.adra.cap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adra.cap.Entity.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{

}
