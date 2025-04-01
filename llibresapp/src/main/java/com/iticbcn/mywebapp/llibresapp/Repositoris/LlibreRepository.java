package com.iticbcn.mywebapp.llibresapp.Repositoris;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iticbcn.mywebapp.llibresapp.Model.Llibre;

@Repository
public interface LlibreRepository extends CrudRepository<Llibre, Long> {
    Set<Llibre> findAll();  

    Set<Llibre> findByTitolContainingIgnoreCase(String titol);  

    Set<Llibre> findByTitolAndEditorial(String titol, String editorial); 
}
