package com.iticbcn.mywebapp.llibresapp.Serveis;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iticbcn.mywebapp.llibresapp.Model.Llibre;
import com.iticbcn.mywebapp.llibresapp.Repositoris.LlibreRepository;

@Service
public class LlibreServiceImpl implements LlibreService {

    private final LlibreRepository llibreRepository;

    @Autowired
    public LlibreServiceImpl(LlibreRepository llibreRepository) {
        this.llibreRepository = llibreRepository;
    }

    @Override
    public Set<Llibre> getAllLlibres() {
        Iterator<Llibre> llibresIterator = llibreRepository.findAll().iterator();
        return convertIterableToSet(llibresIterator);
    }

    @Override
    public Optional<Llibre> findByIdLlibre(Long id) {
        return llibreRepository.findById(id);
    }

    @Override
    public Set<Llibre> findByTitol(String titol) {
        return llibreRepository.findByTitolContainingIgnoreCase(titol);
    }

    @Override
    public Set<Llibre> findByTitolAndEditorial(String titol, String editorial) {
        return llibreRepository.findByTitolAndEditorial(titol, editorial);
    }

    @Override
    public boolean isValidISBN(String isbn) {
        return isbn != null && isbn.length() > 3;
    }

    @Override
    public void saveLlibre(Llibre llibre) {
        if (isValidISBN(llibre.getIsbn())) {
            llibreRepository.save(llibre);
        } else {
            throw new IllegalArgumentException("ISBN no válido");
        }
    }

    private Set<Llibre> convertIterableToSet(Iterator<Llibre> iterator) {
        Set<Llibre> llibresSet = new java.util.HashSet<>();
        iterator.forEachRemaining(llibresSet::add);
        return llibresSet;
    }
}
