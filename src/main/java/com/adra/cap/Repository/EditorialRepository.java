package com.adra.cap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adra.cap.Entity.Editorial;
@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer> {

}
