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

    @Autowired
    //Esto no posee autowired
    //Tiene dependencia de la clase que necesita
    private LibroRepository libroRepository;

    //public LibroService(LibroRepository libroRepository){
    //    this.libroRepository = libroRepository;
    //}

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

        //Agrupar Libro por año
        for(Libro libro : libros){
            int anio = libro.getFechaPublicacion();
            //Clave buscada entre el mapa, el valor se devuelve 
            //si la clave no existe en el mapas
            long libroPorAnio = librosPorAnio.getOrDefault(anio,0L)+1;
            librosPorAnio.put(anio,libroPorAnio);
            
        }
        return librosPorAnio;

    }

    public Libro getLibroMasAntiguo(){
        List<Libro> libros = libroRepository.getLibros();

        if(libros.isEmpty()) return null;
        
        Libro libroMasAntiguo = libros.get(0);

        for(Libro libro : libros){
            if(libro.getFechaPublicacion() < libroMasAntiguo.getFechaPublicacion()){
                libroMasAntiguo = libro;
            }
        }

        return libroMasAntiguo;
    }

    public Libro getLibroMasNuevo(){
        List<Libro> libros = libroRepository.getLibros();

        if(libros.isEmpty()) return null;
        
        Libro libroMasNuevo = libros.get(0);

        for(Libro libro : libros){
            if(libro.getFechaPublicacion() > libroMasNuevo.getFechaPublicacion()){
                libroMasNuevo = libro;
            }
        }

        return libroMasNuevo;
    }

    public List<Libro> listarLibrosOrdenadosPorAnio(){

        return libroRepository.getLibros()
            .stream()//Convierte la lista de libros en un stream, que permite operaciones funcionales como filter,map,sorted,etc
            .sorted((libro1,libro2) -> Integer.compare(libro1.getFechaPublicacion(),libro2.getFechaPublicacion()))// Ordena los elementos del stream
            .toList();//Convierte el stream ordenandose de nuevo a una lista
    }

}
