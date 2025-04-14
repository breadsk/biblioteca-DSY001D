package com.example.biblioteca.controller;

import com.example.biblioteca.model.Libro;//Model
import com.example.biblioteca.service.LibroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> geLibros(){
        return libroService.getLibros();
    }

    @PostMapping
    public Libro agregLibro(@RequestBody Libro libro){
        return libroService.guardarLibro(libro);
    }

}
