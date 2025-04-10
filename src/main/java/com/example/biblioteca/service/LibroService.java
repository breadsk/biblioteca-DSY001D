package com.example.biblioteca.service;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.repository.LibroRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class LibroService {

    //@Autowired
    //Esto no posee autowired
    //Tiene dependencia de la clase que necesita
    private LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository){
        this.libroRepository = libroRepository;
    }

    public List<Libro> getLibros(){
        return libroRepository.getLibros();
    }

    public Libro getLibroPorId(int id){
        return libroRepository.getLibroPorId(id);
    }

    public Libro getLibroPorIsbn(String isbn){
        return libroRepository.getLibroPorIsbn(isbn);
    }

    public Libro getLibroPorAutor(String autor){
        return libroRepository.getLibroPorAutor(autor);
    }

    public Libro guardarLibro(Libro libro){
        return libroRepository.guardarLibro(libro);
    }

    public Libro actuaLibro(Libro libro){
        return libroRepository.actualizarLibro(libro);
    }

    public String eliminarLibro(int id){
        libroRepository.eliminarLibro(id);
        return "Libro Eliminado";
    }

    public int totalLibrosV1(){
        return libroRepository.totalLibros();
    }

    public Map<Integer,Long> calcularLibrosPorAnio(){

        List<Libro> libros = libroRepository.getLibros();

        //Usamos un mapa para almacenar los años y la cantidad de libros
        Map<Integer,Long> librosPorAnio = new HashMap<>();

        //Agrupár Libro por año
        for(Libro libro : libros){
            int anio = libro.getFechaPublicacion();

            
        }
        return null;

    }

}
