package com.iticbcn.mywebapp.llibresapp.Serveis;

import java.util.Optional;
import java.util.Set;

import com.iticbcn.mywebapp.llibresapp.Model.Llibre;

public interface LlibreService {

    Set<Llibre> getAllLlibres();

    Optional<Llibre> findByIdLlibre(Long id);

    Set<Llibre> findByTitol(String titol);

    Set<Llibre> findByTitolAndEditorial(String titol, String editorial);

    boolean isValidISBN(String isbn);

    void saveLlibre(Llibre llibre);
}
