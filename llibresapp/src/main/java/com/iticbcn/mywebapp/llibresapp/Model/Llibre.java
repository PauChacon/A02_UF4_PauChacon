package com.iticbcn.mywebapp.llibresapp.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Llibre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLlibre;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private String titol;

    @Column(nullable = false)
    private String editorial;

    private LocalDate dataPublicacio;
}
