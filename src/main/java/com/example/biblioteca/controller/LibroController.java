package com.example.biblioteca.controller;

import com.example.biblioteca.model.Libro;//Model
import com.example.biblioteca.service.LibroService;//Service

import org.springframework.web.bind.annotation.RestController; // @RestController
import org.springframework.web.bind.annotation.RequestMapping; // @RequestMapping

import org.springframework.beans.factory.annotation.Autowired; // Inyeccion de dependencias

import org.springframework.web.bind.annotation.GetMapping; // GET
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; // POST
import org.springframework.web.bind.annotation.PutMapping; // PUT
import org.springframework.web.bind.annotation.DeleteMapping; //DELETE

import org.springframework.web.bind.annotation.RequestBody;

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

    @GetMapping("{id}")
    public Libro buscarLibroPorId(@PathVariable int id){
        return libroService.getLibroPorId(id);
    }

    @GetMapping("/isbn/{isbn}")

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro){
        return libroService.guardarLibro(libro);
    }

    @PutMapping("{id}")
    public Libro actualizarLibro(@PathVariable int id , @RequestBody Libro libro){
        return libroService.actualizarLibro(libro);
    }

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id){
        return libroService.eliminarLibro(id);
    }

}
