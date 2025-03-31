package com.iticbcn.mywebapp.llibresapp.Serveis;

import com.iticbcn.mywebapp.llibresapp.Model.Llibre;
import com.iticbcn.mywebapp.llibresapp.Repositoris.LlibreRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

@Service
public class LlibreService {
    private final LlibreRepository llibreRepository;

    public LlibreService(LlibreRepository llibreRepository) {
        this.llibreRepository = llibreRepository;
    }

    public Set<Llibre> getAllLlibres() {
        return llibreRepository.findAll();
    }

    public Optional<Llibre> findByIdLlibre(Long id) {
        return llibreRepository.findById(id);
    }

    public Llibre findByTitol(String titol) {
        return llibreRepository.findByTitol(titol);
    }

    public Set<Llibre> findByTitolAndEditorial(String titol, String editorial) {
        return llibreRepository.findByTitolAndEditorial(titol, editorial);
    }

    public boolean isValidISBN(String isbn) {
        return Pattern.matches("\\d{3}-\\d{10}", isbn);
    }

    public void saveLlibre(Llibre llibre) {
        if (isValidISBN(llibre.getIsbn())) {
            llibreRepository.save(llibre);
        } else {
            throw new IllegalArgumentException("ISBN no válido");
        }
    }
}
