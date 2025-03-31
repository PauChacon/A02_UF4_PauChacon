package com.iticbcn.mywebapp.llibresapp.Repositoris;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iticbcn.mywebapp.llibresapp.Model.Llibre;

import java.util.Set;

@Repository
public interface LlibreRepository extends CrudRepository<Llibre, Long> {
    Set<Llibre> findAll();  // Método para obtener todos los libros como Set

    Llibre findByTitol(String titol);  // Buscar por título

    Set<Llibre> findByTitolAndEditorial(String titol, String editorial); // Buscar por título y editorial
}
